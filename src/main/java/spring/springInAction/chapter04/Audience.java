package spring.springInAction.chapter04;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Pointcut("execution(* spring.springInAction.chapter04.Performance.perform(..))")
    public void performance(){}


    @Before("performance()")
    public void silenceCellphones(){
        System.out.println("Silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("Take seats");
    }

    @After("performance()")
    public void applause(){
        System.out.println("CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }
//
//    @Around("performance()")
//    public void watchPerformance(ProceedingJoinPoint joinPoint){
//        try{
//            System.out.println("Silencing cell phones");
//            System.out.println("Taking seats");
//            joinPoint.proceed();
//            System.out.println("CLAP CLAP CLAP");
//        }catch (Throwable e){
//            System.out.println("Demanding a refund");
//        }
//    }
}
