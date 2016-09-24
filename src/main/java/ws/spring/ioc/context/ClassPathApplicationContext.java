package ws.spring.ioc.context;

import ws.spring.ioc.BeanDefinition;
import ws.spring.ioc.factory.AbstractBeanFactory;
import ws.spring.ioc.factory.AutowireCapableBeanFactory;
import ws.spring.ioc.io.ResourceLoader;
import ws.spring.ioc.xml.XmlBeanDefinitionReader;

import java.util.Map;
import java.util.Set;

/**
 * Created by wangsong on 16-9-24.
 */
public class ClassPathApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathApplicationContext(String configLocation, AbstractBeanFactory factory) throws Exception {
        super(factory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinition(configLocation);

        Set<Map.Entry<String, BeanDefinition>> entries = reader.getRegistry().entrySet();
        for (Map.Entry<String, BeanDefinition> entry : entries) {
            //在工厂注册
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }

//        beanFactory.preInstantiateSingletons();
    }

}
