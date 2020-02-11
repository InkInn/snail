package spring.geek;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author rcli
 * Created on 2020/2/7.
 */

public class BeanFactoryIoCContainerDemo {

    public static void main(String[] args) {
        // 创建BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "";
    }
}
