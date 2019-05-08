package annotation;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    @AroundAuthority(methodName = "getMessage")
    public String getMessage() {
        System.out.println("Hello, welcome to [LoginService-getMessage]");
        return "HelloWorld";
    }


    @AroundAuthority(methodName = "loginIn")
    public String loginInString(String userName, String passwd) {
        System.out.println("This is loginIn method, [ user: " + userName + ", passwd:" + passwd + "]");
        return "HelloWorld";
    }


}
