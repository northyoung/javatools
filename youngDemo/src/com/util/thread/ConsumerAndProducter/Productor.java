package com.util.thread.ConsumerAndProducter;

/**
 * Created by sunsy3 on 2015/2/13.
 */
public class Productor implements Runnable {
    MulConcuPro mulConcuPro = null;
    public Productor(MulConcuPro mulConcuProtmp){
        mulConcuPro = mulConcuProtmp;
    }
    public Productor(){}
    @Override
    public void run() {
        while(true){
            mulConcuPro.ProducterFunction();
        }
    }
}
