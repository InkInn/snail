package annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Random;

@Aspect
@Component
public class AroundAspect {

    @Around("@annotation(around)")
    public void aroundAuthority(ProceedingJoinPoint point, AroundAuthority around) throws Throwable{
        Random random = new Random();
        Boolean b = random.nextBoolean();

        System.out.println("Aspect-start: [AroundAspect-aroundAuthority]");
        System.out.println("Method is : " + around.methodName());

        if(b){
            System.out.println("Authority is accept[success]");
            Object result = point.proceed();
            System.out.println(around.methodName() + "exec result :" + result.toString());
        }else {
            System.out.println("Authority is not accept[fail]");
        }
        System.out.println("Aspect-end: [AroundAspect-aroundAuthority]");
    }
}
