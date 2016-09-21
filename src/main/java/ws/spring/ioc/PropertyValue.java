package ws.spring.ioc;

import lombok.Data;

/**
 * Created by wangsong on 16-9-21
 *
 * 类的属性值.
 */
@Data
public class PropertyValue {

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private Object value;
}
