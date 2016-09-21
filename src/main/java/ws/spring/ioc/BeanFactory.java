package ws.spring.ioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wangsong on 16-9-21.
 */
public class BeanFactory {

    private Map<String, BeanDefinition> map = new ConcurrentHashMap<>();

    public void register(String name, BeanDefinition beanDefinition) {
        map.put(name, beanDefinition);
    }

    public BeanDefinition getBeanDefinition(String name) {
        return map.get(name);
    }

}
