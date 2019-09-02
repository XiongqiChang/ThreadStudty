package com.ccnu.juc.c002;

import java.util.concurrent.TimeUnit;

/**
 * 模拟一个银行的账户
 * 对业务写的方法进行加锁
 * 对业务读的方法不加锁
 */
public class AccountBalance {

    private  String name;
    private  int balance;

    public  synchronized  void  set(String name, int balance){
        this.name = name;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;
    }

    public int getBalance(String name){
        return  this.balance;
    }

    public static void main(String[] args) {
        AccountBalance accountBalance = new AccountBalance();
        //这是JAVA8之后的新的写法
        new Thread(()->accountBalance.set("张三",1000)).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(accountBalance.getBalance("张三"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(accountBalance.getBalance("张三"));
    }
}