package com.iduoyu.Time;

import java.util.TimerTask;

public class MyTask1 extends TimerTask {
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("您该起床了!!!!");
        }
    }
}
