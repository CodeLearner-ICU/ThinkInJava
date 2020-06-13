package thinkinjava.date9;

import java.sql.Date;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class Demo {
    public static void main(String args[]) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(new Task(countDownLatch),"Thread1").start();
        //Thread.sleep(10000);
        System.out.println("主线程执行中1111");
        new Thread(new Task(countDownLatch),"thread2").start();
        //Thread.sleep(10000);
        System.out.println("主线程执行中2222");
        new Thread(new Task(countDownLatch),"thread3").start();
        System.out.println("主线程执行中333");
        countDownLatch.await();
        System.out.println("所有线程已到达，主线程结束执行");
    }
}
class Task implements Runnable{
    private CountDownLatch countDownLatch;
    public Task(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    public void run() {
        System.out.println("线程："+Thread.currentThread().getName()+"已经到达");
        countDownLatch.countDown();
        System.out.println("线程："+Thread.currentThread().getName()+"已经结束");
    }
}