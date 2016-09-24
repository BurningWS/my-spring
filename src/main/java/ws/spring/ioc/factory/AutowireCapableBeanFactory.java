package ws.spring.ioc.factory;

import ws.spring.ioc.BeanDefinition;
import ws.spring.ioc.BeanReference;
import ws.spring.ioc.PropertyValue;

import java.lang.reflect.Field;

/**
 * Created by wangsong on 16-9-21.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreatBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean); //解决循环依赖问题
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    //反射创建对象
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        String beanClassName = beanDefinition.getBeanClassName();
        Class<?> beanClass = Class.forName(beanClassName);
        beanDefinition.setBeanClass(beanClass);
        return beanClass.newInstance();
    }

    //添加属性值
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        Class beanClass = beanDefinition.getBeanClass();
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Field field = beanClass.getDeclaredField(propertyValue.getName());
            field.setAccessible(true);

            Object value = propertyValue.getValue(); //属性为简单的String对象
            if (value instanceof BeanReference) { //引用对象
                BeanReference ref = (BeanReference) value;
                value = getBean(ref.getName());
            }

            field.set(bean, value);
        }
    }
}


