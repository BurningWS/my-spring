package ws.spring.ioc;

import lombok.Data;

/**
 * Created by wangsong on 16-9-24.
 */
@Data
public class BeanReference {

    private String name;
    private Object ref;

    public BeanReference(String name) {
        this.name = name;
    }
}
