package com.ccnu.juc.c002;

/**
 * 对于Synchronized的话这个锁是可重入锁的
 * 可重入锁指的是对于当前对象一把锁可以锁定另外一把锁
 */
public class SynchronizedStudy03 {

    synchronized  void  m1(){
        System.out.println(" m1 start");
        try {
            Thread.sleep(2000);
            m2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 end");
    }

    synchronized  void  m2(){
        System.out.println("m2 start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        System.out.println("m2  end");
    }

    public static void main(String[] args) {
        SynchronizedStudy03 synchronizedStudy03 = new SynchronizedStudy03();
        synchronizedStudy03.m1();
    }

}
