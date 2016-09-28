package ws.spring.aop;

import org.junit.Test;
import ws.spring.ioc.HelloWorldService;
import ws.spring.ioc.aop.AdvicedSupport;
import ws.spring.ioc.aop.JdkDynamicProxy;
import ws.spring.ioc.aop.TargetSource;
import ws.spring.ioc.context.ApplicationContext;
import ws.spring.ioc.context.ClassPathApplicationContext;

/**
 * Created by wangsong on 16-9-28.
 */
public class ProxyTest {

    @Test
    public void test() throws Exception {
        ApplicationContext context = new ClassPathApplicationContext("myioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloWorldService");
        helloWorldService.helloWorld();

        TargetSource targetSource = new TargetSource(HelloWorldService.class, helloWorldService);
        AdvicedSupport advicedSupport = new AdvicedSupport(targetSource, new TimeInterceptor());
        Object proxy = new JdkDynamicProxy(advicedSupport).getProxy();
        helloWorldService = (HelloWorldService)proxy;
        helloWorldService.helloWorld();

    }
}
