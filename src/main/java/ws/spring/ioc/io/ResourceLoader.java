package ws.spring.ioc.io;

import java.net.URL;

/**
 * Created by wangsong on 16-9-22.
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
