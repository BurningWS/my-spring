package ws.spring.ioc;

import org.junit.Test;
import ws.spring.ioc.factory.AutowireCapableBeanFactory;

/**
 * Created by wangsong on 16-9-21.
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        //创建工厂
        AutowireCapableBeanFactory bf = new AutowireCapableBeanFactory();

        //创建BeanDefinition
        BeanDefinition bean = new BeanDefinition();
        bean.setBeanClassName("ws.spring.ioc.HelloWorldService");

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "WS"));
        bean.setPropertyValues(propertyValues);

        //在工厂注册
        bf.register("helloService", bean);

        //调用
        ((HelloWorldService) bf.getBeanDefinition("helloService").getBean()).helloWorld();
    }
}
