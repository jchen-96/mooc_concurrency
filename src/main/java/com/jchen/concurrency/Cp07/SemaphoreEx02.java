package com.jchen.concurrency.Cp07;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreEx02 {
    private static int threadCount=20;
    public static void main(String[] args) throws Exception{
        ExecutorService exec= Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch=new CountDownLatch(threadCount);

        final Semaphore semaphore=new Semaphore(3);


        for (int i = 0; i <threadCount ; i++) {
            final int threadNum=i;
            exec.execute(()->{
                try {
                    semaphore.acquire(3);//获得多个许可，一次性只能执行一个线程
                    test(threadNum);
                    semaphore.release(3);//释放多个许可
                }catch (Exception e){
                    log.info("exception",e);
                }
            });
        }

        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        log.info("{}",threadNum);
        Thread.sleep(1000);
    }
}
