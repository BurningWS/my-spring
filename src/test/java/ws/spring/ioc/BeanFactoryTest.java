package ws.spring.ioc;

import org.junit.Test;
import ws.spring.ioc.context.ApplicationContext;
import ws.spring.ioc.context.ClassPathApplicationContext;
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
    public void testApplicationContext() throws Exception {
        ApplicationContext context = new ClassPathApplicationContext("myioc.xml");
        ((HelloWorldService) context.getBean("helloWorldService")).helloWorld();
    }

    @Test
    public void test() throws Exception {
        //创建工厂
        AutowireCapableBeanFactory bf = new AutowireCapableBeanFactory();

        //创建BeanDefinition
        ResourceLoader resourceLoader = new ResourceLoader();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(resourceLoader);
        reader.loadBeanDefinition("myioc.xml");

        Set<Map.Entry<String, BeanDefinition>> entries = reader.getRegistry().entrySet();
        for (Map.Entry<String, BeanDefinition> entry : entries) {
            //在工厂注册
            bf.registerBeanDefinition(entry.getKey(), entry.getValue());
        }

        //恶汉加载
        bf.preInstantiateSingletons();

        //调用
        ((HelloWorldService) bf.getBean("helloWorldService")).helloWorld();
    }
}
