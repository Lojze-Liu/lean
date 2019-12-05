package 面试相关.java并发编程;

import com.google.common.collect.Lists;
import com.sun.tools.javac.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

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


    @Test
    public void test2() throws InterruptedException {
        ReentrantLock r = new ReentrantLock();
        r.lock();
    }

}
