package spring.springInAction.chapter04;

public class HelloWord {

    public void sayHello(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        HelloWord helloWord = new HelloWord();
        helloWord.sayHello();
    }
}
