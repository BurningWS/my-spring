package ws.spring.ioc;

/**
 * Created by wangsong on 16-9-21.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreatBean(BeanDefinition beanDefinition) {
        String beanClassName = beanDefinition.getBeanClassName();
        try {
            Class<?> beanClass = Class.forName(beanClassName);
            beanDefinition.setBeanClass(beanClass);
            return beanClass.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
