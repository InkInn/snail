package customTag;

import bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.getUserName() + "------" + user.getEmail());
    }
}
