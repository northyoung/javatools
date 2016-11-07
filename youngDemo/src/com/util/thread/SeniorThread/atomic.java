package com.util.thread.SeniorThread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 2016/11/5 0005.
 *
 * valatile
 */
public class atomic {
    AtomicBoolean atomicBoolean = new AtomicBoolean();
    AtomicInteger atomicInteger = new AtomicInteger();
    AtomicLong atomicLong = new AtomicLong();
    int[] a1 = {1,2,3,4};
    AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(a1);


}
