package com.jchen.concurrency.Cp07;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CyclicBarrEx02 {

    private static CyclicBarrier cyclicBarrier=new CyclicBarrier(5,()->{
        log.info("callback is running");//达到内存屏障首先执行这个
    });

    public static void main(String[] args) throws Exception {
        ExecutorService executorService= Executors.newCachedThreadPool();


        for (int i = 0; i < 10; i++) {
            final int threadNum=i;

            Thread.sleep(1000);
            executorService.execute(()->{
                try {
                   race(threadNum);
                }catch (Exception e){
                    log.error("exception",e);
                }
            });
        }

        executorService.shutdown();
    }

    private static void race(int threadNum) throws Exception{
        Thread.sleep(1000);
        log.info("{} is ready",threadNum);
        cyclicBarrier.await();
        log.info("{} continue",threadNum);
    }
}
