package com.util.thread.concurrentPackage.BlockingDeque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Á´×èÈûË«¶Ë¶ÓÁÐ
 * Created by Administrator on 2016/12/2 0002.
 */
public class BlockingDequeExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> deque = new LinkedBlockingDeque<String>();
        deque.addFirst("1");
        deque.addLast("2");
        String two = deque.takeLast();
        String one = deque.takeFirst();
    }
}
