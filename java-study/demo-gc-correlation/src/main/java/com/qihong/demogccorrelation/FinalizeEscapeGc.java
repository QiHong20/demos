package com.qihong.demogccorrelation;

@SuppressWarnings("ALL")
public class FinalizeEscapeGc {
    public static FinalizeEscapeGc SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am stiall a live");

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("finalize method executed!");
        FinalizeEscapeGc.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGc();
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.printf("no ,i am dead :(");
        }
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.printf("no ,i am dead :(");
        }


    }
}
