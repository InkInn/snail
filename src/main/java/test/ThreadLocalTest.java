package test;

/**
 * @author rcli
 * Created on 2019/11/29.
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocalTest sn = new ThreadLocalTest();
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();

    }

    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);


    public int getNextNum(){
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    private static class TestClient extends Thread{

        private ThreadLocalTest sn;

        public TestClient(ThreadLocalTest sn){
            this.sn = sn;
        }

        public void run(){
            for (int i = 0; i < 3; i++){
                System.out.println(Thread.currentThread().getName()  + " " + sn.getNextNum());
            }
        }
    }
}
