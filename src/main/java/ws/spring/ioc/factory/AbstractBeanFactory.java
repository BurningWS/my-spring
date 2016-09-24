package ws.spring.ioc.factory;

import ws.spring.ioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wangsong on 16-9-21.
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> map = new ConcurrentHashMap<>();

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        map.put(name, beanDefinition);
    }

    protected abstract Object doCreatBean(BeanDefinition beanDefinition) throws Exception;

    //采用懒加载
    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = map.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException(String.format("No bean named '%s' is defined", name));
        }

        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreatBean(beanDefinition);
        }

        return bean;
    }

    public void preInstantiateSingletons() throws Exception {
        for (String name : map.keySet()) {
            getBean(name);
        }
    }
}
