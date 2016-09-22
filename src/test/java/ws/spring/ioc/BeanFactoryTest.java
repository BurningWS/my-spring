package ws.spring.ioc;

import org.junit.Test;
import ws.spring.ioc.factory.AutowireCapableBeanFactory;
import ws.spring.ioc.io.ResourceLoader;
import ws.spring.ioc.xml.XmlBeanDefinitionReader;

import java.util.Map;
import java.util.Set;

/**
 * Created by wangsong on 16-9-21.
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        //创建工厂
        AutowireCapableBeanFactory bf = new AutowireCapableBeanFactory();

        //创建BeanDefinition
        ResourceLoader resourceLoader = new ResourceLoader();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(resourceLoader);
        reader.loadBeanDefinition("myioc.xml");

        Set<Map.Entry<String, BeanDefinition>> entries = reader.getRegistry().entrySet();
        for (Map.Entry<String, BeanDefinition> entry : entries) {
            //在工厂注册
            bf.register(entry.getKey(), entry.getValue());
        }

        //调用
        ((HelloWorldService) bf.getBeanDefinition("helloWorldService").getBean()).helloWorld();
    }
}
