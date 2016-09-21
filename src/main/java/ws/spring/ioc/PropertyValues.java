package ws.spring.ioc;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsong on 16-9-21.
 */
public class PropertyValues {

    @Getter
    private List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
    }

}
