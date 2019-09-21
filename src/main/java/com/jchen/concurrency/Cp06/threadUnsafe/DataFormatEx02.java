package com.jchen.concurrency.Cp06.threadUnsafe;

import com.jchen.concurrency.annoations.NotThreadSafe;
import com.jchen.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


@Slf4j
@ThreadSafe
public class DataFormatEx02 {

    public static int clientTotal=5000;

    public static int threadTotal=200;



    public static void main(String[] args) throws Exception{
        ExecutorService executorService= Executors.newCachedThreadPool();

        final Semaphore semaphore=new Semaphore(threadTotal);

        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);

        for (int i = 0; i <clientTotal ; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    praseDate();
                    semaphore.release();
                }catch (Exception e){
                    log.error("execption",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }

    private static void praseDate(){
        try {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyMMdd");

            simpleDateFormat.parse("20180208");
        }catch (Exception e){
            log.error("paerseexception",e);
        }
    }
}
