package com.ccnu.juc.c002;

import sun.awt.windows.ThemeReader;

/**
 * 同步方法和非同步方法都是可以同时调用的
 */
public class SynchronizedStudy02 {

    public synchronized  void m1(){
        System.out.println(Thread.currentThread().getName() + "m1 start");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "m1 stop");
    }


    public void m2(){
        System.out.println(Thread.currentThread().getName() + "m2 start");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m2 stop");
    }

    public static void main(String[] args) {
        SynchronizedStudy02 ss = new SynchronizedStudy02();
        new Thread(()->ss.m1(),"t1").start();
        new Thread(()->ss.m2(),"t2").start();
    }
}
