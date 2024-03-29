package com.jchen.concurrency.Cp04;


import com.jchen.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@ThreadSafe
public class AtomicExample06 {

    private static AtomicBoolean ishappened=new AtomicBoolean(false);


    public static int clientTotal=5000;

    public static int threadTotal=200;



    public static void main(String[] args)throws Exception {
        ExecutorService executorService= Executors.newCachedThreadPool();

        final Semaphore semaphore=new Semaphore(threadTotal);

        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try{
                    semaphore.acquire();
                    test();
                    semaphore.release();
                }catch (Exception e){
                    log.error("exception",e);
                }
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        log.info("isHappened:{}",ishappened.get());
    }

    private static void test(){

//        保证只执行一次，绝对不会重复
        if(ishappened.compareAndSet(false,true)){
            log.info("execute");
        }
    }
}
