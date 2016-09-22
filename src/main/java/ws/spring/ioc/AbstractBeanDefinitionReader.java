package ws.spring.ioc;

import lombok.Getter;
import ws.spring.ioc.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangsong on 16-9-22.
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    @Getter
    private Map<String, BeanDefinition> registry = new HashMap<>();

    @Getter
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
