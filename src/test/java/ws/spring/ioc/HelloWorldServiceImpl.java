package ws.spring.ioc;

/**
 * Created by wangsong on 16-9-28.
 */
public class HelloWorldServiceImpl implements HelloWorldService{
    private String text;

    private OutputService outputService;

    @Override
    public void helloWorld(){
        outputService.output(text);
    }
}
