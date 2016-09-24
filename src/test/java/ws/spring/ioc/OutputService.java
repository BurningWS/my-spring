package ws.spring.ioc;

import org.junit.Assert;

/**
 * @author yihua.huang@dianping.com
 */
public class OutputService {

    private HelloWorldService helloWorldService;

    public void output(String text){
        Assert.assertNotNull(helloWorldService);
        System.out.println(text);
    }

}
