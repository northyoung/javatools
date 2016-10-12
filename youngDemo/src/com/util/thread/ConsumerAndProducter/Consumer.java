package com.util.thread.ConsumerAndProducter;

/**
 * Created by sunsy3 on 2015/2/13.
 */
public class Consumer implements Runnable {
    MulConcuPro mulConcuPro = null;
    public Consumer(MulConcuPro mulConcuProtmp){
        mulConcuPro = mulConcuProtmp;
    }
    public Consumer(){}
    @Override
    public void run() {
        while(true){
            mulConcuPro.ConsumerFunction();
        }
    }
}
