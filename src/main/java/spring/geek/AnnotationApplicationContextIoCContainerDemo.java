package spring.geek;

import bean.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author rcli
 * Created on 2020/2/7.
 */

@Configuration
public class AnnotationApplicationContextIoCContainerDemo {


    public static void main(String[] args) {
        // 创建BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类作为配置类
        applicationContext.register(AnnotationApplicationContextIoCContainerDemo.class);
        // 启动应用上下文
        applicationContext.refresh();
        lookupCollectionByType(applicationContext);
    }

    @Bean
    public User user(){
        User user = new User();
        user.setId("1");
        user.setUserName("小明");
        return user;
    }


    private static void lookupCollectionByType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(userMap);
        }
    }


}
