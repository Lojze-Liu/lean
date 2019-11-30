package 面试相关.java并发编程;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lojze liu
 * @since 2019/11/29 1:04 上午
 */
public class TestClass {

    @Test
    public void test() {
        AtomicInteger a = new AtomicInteger(1);

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
                System.out.println("设置为2");
                a.compareAndSet(1, 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(r).start();

        while (true) {
            boolean b = a.compareAndSet(2, 3);
            if (b) {
                break;
            }
        }

        System.out.println(a.get());
    }


    private synchronized void doSth() throws InterruptedException {
        System.out.println("执行开始");
        Thread.sleep(10000);
        System.out.println("执行完毕");
    }

    @Test
    public void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                doSth();
                System.out.println("t1执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread t2 = new Thread(() -> {
            try {
                doSth();
                System.out.println("t2执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();


        TimeUnit.SECONDS.sleep(60000);
    }
}
