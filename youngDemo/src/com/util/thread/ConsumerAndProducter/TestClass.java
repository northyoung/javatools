package com.util.thread.ConsumerAndProducter;

/**
 * Created by sunsy3 on 2015/2/13.
 */
public class TestClass {
    public static void main(String[] args) {
        MulConcuPro mulConcuPro = new MulConcuPro();
        Thread thread11 = new Thread(new Consumer(mulConcuPro));
        Thread thread12 = new Thread(new Consumer(mulConcuPro));

        Thread thread21 = new Thread(new Productor(mulConcuPro));
        Thread thread22 = new Thread(new Productor(mulConcuPro));

        thread11.start();
        thread12.start();
        thread21.start();
        thread22.start();
    }
}
