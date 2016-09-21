package ws.spring.ioc.factory;

import ws.spring.ioc.BeanDefinition;

/**
 * Created by wangsong on 16-9-21.
 */
public interface BeanFactory {

    void register(String name, BeanDefinition beanDefinition);

    BeanDefinition getBeanDefinition(String name);
}
