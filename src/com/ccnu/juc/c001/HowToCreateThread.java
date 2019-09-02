package com.ccnu.juc.c001;

/**
 * 创建线程的方式有三种的，一种是继承一个Thread,还有一个是实现Runnable的接口，以及还有一种是实现Callback的接口
 *
 */
public class HowToCreateThread {

    static  class MyThread extends  Thread{
        @Override
        public void run() {
            System.out.println("hello mythread");
        }
    }

    static  class  MyRun implements Runnable{

        @Override
        public void run() {
            System.out.println("hello runThread");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
    }
}
