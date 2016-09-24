package ws.spring.ioc.factory;


/**
 * Created by wangsong on 16-9-21.
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;
}
