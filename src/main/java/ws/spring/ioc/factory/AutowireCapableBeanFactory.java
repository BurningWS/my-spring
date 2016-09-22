package ws.spring.ioc.factory;

import ws.spring.ioc.BeanDefinition;
import ws.spring.ioc.PropertyValue;

import java.lang.reflect.Field;

/**
 * Created by wangsong on 16-9-21.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreatBean(BeanDefinition beanDefinition) {
        try {
            Object bean = createBeanInstance(beanDefinition);
            applyPropertyValues(bean, beanDefinition);
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //反射创建对象
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        String beanClassName = beanDefinition.getBeanClassName();
        Class<?> beanClass = Class.forName(beanClassName);
        beanDefinition.setBeanClass(beanClass);
        return beanClass.newInstance();
    }

    //添加属性值
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
            try {
                Field field = beanClass.getDeclaredField(propertyValue.getName());
                field.setAccessible(true);
                field.set(bean, propertyValue.getValue());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
