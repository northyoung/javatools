package com.util.thread.concurrentPackage.SynchronousQueue;

/**
 * Created by Administrator on 2016/12/2 0002.
 * SynchronousQueue 类实现了 BlockingQueue 接口。
 SynchronousQueue 是一个特殊的队列，它的内部同时只能够容纳单个元素。
 如果该队列已有一元素的话，试图向队列中插入一个新元素的线程将会阻塞，
 直到另一个线程将该元素从队列中抽走。同样，如果该队列为空，试图向队
 列中抽取一个元素的线程将会阻塞，直到另一个线程向队列中插入了一条新
 的元素。
 */
public class SynchronousQueueExample {
}
