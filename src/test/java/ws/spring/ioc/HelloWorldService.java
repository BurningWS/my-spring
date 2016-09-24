package ws.spring.ioc;

/**
 * @author yihua.huang@dianping.com
 */
public class HelloWorldService {

    private String text;

    private OutputService outputService;

    public void helloWorld(){
        outputService.output(text);
    }

}
