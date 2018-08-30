package spring.springInAction.chapter04;

public aspect MyAspectJDemo {

    pointcut recordLog():call(* HelloWord.sayHello(..));

    pointcut authCheck():call(* HelloWord.sayHello(..));

    before():authCheck(){
        System.out.println("sayHello方法执行前权限验证");
    }

    after():recordLog(){
        System.out.println("sayHello方法执行后记录日志");
    }
}
