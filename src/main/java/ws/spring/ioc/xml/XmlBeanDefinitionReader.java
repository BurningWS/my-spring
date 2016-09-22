package ws.spring.ioc.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import ws.spring.ioc.AbstractBeanDefinitionReader;
import ws.spring.ioc.BeanDefinition;
import ws.spring.ioc.PropertyValue;
import ws.spring.ioc.PropertyValues;
import ws.spring.ioc.io.ResourceLoader;

import java.io.InputStream;
import java.util.List;

/**
 * Created by wangsong on 16-9-22.
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinition(String location) {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinition(inputStream);
    }

    private void doLoadBeanDefinition(InputStream inputStream) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(inputStream);
            //解析spring配置，注册到registry
            registerBeanDefinition(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void registerBeanDefinition(Document document) {
        Element root = document.getRootElement();
        parseBeanDefinition(root);
    }

//    public static void main(String[] args) {
//        ResourceLoader r = new ResourceLoader();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(r);
//        reader.loadBeanDefinition("myioc.xml");
//    }

    //这里如果用xpath解析真麻烦啊
    private void parseBeanDefinition(Element root) {
        List<Element> beans = root.elements("bean");
        for (Element bean : beans) {
            processBeanDefinition(bean);
        }
    }

    private void processBeanDefinition(Element bean) {
        String name = bean.attributeValue("name");
        String className = bean.attributeValue("class");

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName(className);

        //处理类的属性值
        processProperties(bean, beanDefinition);

        getRegistry().put(name, beanDefinition);
    }

    private void processProperties(Element bean, BeanDefinition beanDefinition) {
        List<Element> properties = bean.elements("property");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        for (Element property : properties) {
            String name = property.attributeValue("name");
            String value = property.attributeValue("value");
            PropertyValue propertyValue = new PropertyValue(name, value);
            propertyValues.addPropertyValue(propertyValue);
        }

    }
}
