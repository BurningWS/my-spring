package ws.spring.ioc.context;

import ws.spring.ioc.factory.AbstractBeanFactory;

/**
 * Created by wangsong on 16-9-24.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory factory) {
        this.beanFactory = factory;
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }

    public abstract void refresh() throws Exception;
}
