package com.qihong.democoncurrent.synchronizeddemo;

/**
 * 静态同步方法，锁是当前类的class对象
 */
public class StaticFunctionSynchronizedTest {
    public static synchronized void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public static synchronized void method2() {
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
        final StaticFunctionSynchronizedTest test = new StaticFunctionSynchronizedTest();
        final StaticFunctionSynchronizedTest test2 = new StaticFunctionSynchronizedTest();

        new Thread(new Runnable() {
            public void run() {
                StaticFunctionSynchronizedTest.method1();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                StaticFunctionSynchronizedTest.method2();
            }
        }).start();
    }
}

