package ws.spring.ioc.factory;

import ws.spring.ioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wangsong on 16-9-21.
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> map = new ConcurrentHashMap<>();

    @Override
    public void register(String name, BeanDefinition beanDefinition) {
        Object bean = doCreatBean(beanDefinition);
        beanDefinition.setBean(bean);
        map.put(name, beanDefinition);
    }

    protected abstract Object doCreatBean(BeanDefinition beanDefinition);

    @Override
    public BeanDefinition getBeanDefinition(String name) {
        return map.get(name);
    }

}
