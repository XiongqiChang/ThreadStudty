package com.ccnu.juc.c002;

/**
 * 对于Synchronized的话这个锁是可重入锁的
 */
public class SynchronizedStudy03 {

    synchronized  void  m1(){
        System.out.println(" m1 start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized  int m2(){
        System.out.println("m2 start");
        int i = 1;
        try {
//            int j = 1 / 0;
            return i;
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            i = 2;
            e.printStackTrace();
        }finally {
            i = 3;
            return i;
        }
    }
}
