package ws.spring.ioc;

import org.junit.Test;

/**
 * Created by wangsong on 16-9-21.
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        BeanFactory beanFactory = new BeanFactory();
        BeanDefinition bean = new BeanDefinition(new HelloWorldService());
        beanFactory.register("helloService", bean);

        ((HelloWorldService)beanFactory.getBeanDefinition("helloService").getBean()).helloWorld();
    }
}
