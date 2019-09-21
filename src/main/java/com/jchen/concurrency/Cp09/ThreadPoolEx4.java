package com.jchen.concurrency.Cp09;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Slf4j
public class ThreadPoolEx4 {
    public static void main(String[] args) {
        ScheduledExecutorService exec= Executors.newScheduledThreadPool(5);
        exec.schedule(new Runnable() {
            @Override
            public void run() {
                log.warn("schedule run");
            }
        },3, TimeUnit.SECONDS);

        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.warn("runrunrun");
            }
        },1,3,TimeUnit.SECONDS);//间隔几秒一直执行
//        exec.shutdown();
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        },new Date(),5000);//指定指定时间运行
    }

}
