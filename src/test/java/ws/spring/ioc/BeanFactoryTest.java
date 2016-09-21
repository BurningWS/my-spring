package ws.spring.ioc;

import org.junit.Test;

/**
 * Created by wangsong on 16-9-21.
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        AutowireCapableBeanFactory bf = new AutowireCapableBeanFactory();
        BeanDefinition bean = new BeanDefinition();
        bean.setBeanClassName("ws.spring.ioc.HelloWorldService");
        bf.register("helloService", bean);

        ((HelloWorldService)bf.getBeanDefinition("helloService").getBean()).helloWorld();
    }
}
