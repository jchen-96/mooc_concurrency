package com.jchen.concurrency.Cp07;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CountDownLatchEx01 {
    private static int threadCount=200;
    public static void main(String[] args) throws Exception{
        ExecutorService exec= Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch=new CountDownLatch(threadCount);

        for (int i = 0; i <threadCount ; i++) {
            final int threadNum=i;
            exec.execute(()->{
                try {
                    test(threadNum);
                }catch (Exception e){
                    log.info("exception",e);
                }finally {
                    countDownLatch.countDown();
                }
            });
        }

        //等待指定的时间，没有结束也停止程序的运行
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(10);
        log.info("{}",threadNum);
    }
}
