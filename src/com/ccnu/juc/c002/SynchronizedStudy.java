package com.ccnu.juc.c002;

/**
 * Synchronized的这个是锁定的是当前的对象的，synchronized的这个可以锁的是方法，代码块，以及类
 */
public class SynchronizedStudy implements  Runnable {

    private int count = 10;
    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + "count= " + count);

    }

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++){

            SynchronizedStudy synchronizedStudy = new SynchronizedStudy();
            new Thread(synchronizedStudy, "Thread" + i).start();
        }
    }
}
