package com.qihong.democoncurrent.synchronizeddemo;

/**
 * 同步方法块，锁是括号里面的对象
 */
public class LockObjectSynchronizedTest {

    public void method1() {
        System.out.println("Method 1 start");
        try {
            synchronized (this) {
                System.out.println("Method 1 execute");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public void method2() {
        System.out.println("Method 2 start");
        try {
            synchronized (this) {
                System.out.println("Method 2 execute");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }

    public static void main(String[] args) {
        final LockObjectSynchronizedTest test = new LockObjectSynchronizedTest();

        new Thread(new Runnable() {
            public void run() {
                test.method1();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                test.method2();
            }
        }).start();
    }
}
