package ws.spring.ioc;


public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object obj) {
        this.bean = obj;
    }

    public Object getBean() {
        return bean;
    }
}

