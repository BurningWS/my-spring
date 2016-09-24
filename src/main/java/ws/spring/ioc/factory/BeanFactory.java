package ws.spring.ioc.factory;


import ws.spring.ioc.BeanDefinition;

/**
 * Created by wangsong on 16-9-21.
 */
public interface BeanFactory {

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;

    Object getBean(String name) throws Exception;
}
