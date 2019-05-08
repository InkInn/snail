package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class HttpAopAdviseDefine {

    @Pointcut("@annotation(aop.AuthChecker)")
    public void pointcut(){}


    @Around("pointcut()")
    public Object checkAuth(ProceedingJoinPoint joinPoint) throws Throwable{
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String token = getUserToken(request);
        if(!token.equalsIgnoreCase("123456")){
            return "no auth";
        }
        return joinPoint.proceed();

    }


    private String getUserToken(HttpServletRequest request){
        Cookie[]  cookies = request.getCookies();
        if(cookies == null){
            return "";
        }

        for (Cookie cookie: cookies){
            if(cookie.getName().equalsIgnoreCase("user.token")){
                return cookie.getValue();
            }
        }
        return "";
    }

}
