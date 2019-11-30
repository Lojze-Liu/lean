package 面试相关.java并发编程;

import org.junit.Test;
import sun.misc.Unsafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lojze liu
 * @since 2019/11/30 12:39 上午
 */
public class Test2 {


    public static void main(String[] args) throws InterruptedException {
        deathLock();
    }

    public static void deathLock() throws InterruptedException {

        synchronized(Test2.class) {
            Runnable target = () -> {
                try {
                    while (true) {
                        Test2.class.wait();
                        System.out.println("1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
            };
            Thread t1 = new Thread(target, "t1");
            t1.start();

        }


        TimeUnit.SECONDS.sleep(10);
        Test2.class.notify();
        TimeUnit.MINUTES.sleep(100);

    }


}
