package com.yoyocheknow.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类说明
 *
 * @author zhangzhihua
 * @date 2018/5/24 10:25
 */
public class Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //创建一个可重用固定线程数的线程池
        ExecutorService cachedThreadPool= Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(2);
        ExecutorService pool3=Executors.newScheduledThreadPool(3);
        ReentrantLock reentrantLock=new ReentrantLock();
        reentrantLock.lock();
        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口;


        Thread t1=new MyThread();

        Thread t2=new MyThread();

        Thread t3=new MyThread();

        Thread t4=new MyThread();

        Thread t5=new MyThread();

        //将线程放到池中执行；

        cachedThreadPool.execute(t1);
        cachedThreadPool.execute(t2);
        cachedThreadPool.execute(t3);
        cachedThreadPool.execute(t4);
        cachedThreadPool.execute(t5);

        //关闭线程池

        cachedThreadPool.shutdown();


    }

}

 class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行....");
    }

}