package com.qihong.democoncurrent.synchronizeddemo;

/**
 * 普通同步方法，锁是当前实例对象
 */
public class ObjectFunctionSynchronizedTest {
    public synchronized void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public synchronized void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }

    public static void main(String[] args) {
        final ObjectFunctionSynchronizedTest test = new ObjectFunctionSynchronizedTest();
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

