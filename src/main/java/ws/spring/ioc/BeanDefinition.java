package ws.spring.ioc;

import lombok.Data;

@Data
public class BeanDefinition {

    private Object bean;
    private Class beanClass;
    private String beanClassName;
    private PropertyValues propertyValues = new PropertyValues();
}

