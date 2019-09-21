package com.jchen.concurrency.Cp06.collectionExs;

import com.jchen.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


@NotThreadSafe
@Slf4j
public class ArrayListEx {
    public static int clientTotal=5000;

    public static int threadTotal=200;

    private static List<Integer> list=new ArrayList<>();




    public static void main(String[] args) throws Exception{
        ExecutorService executorService= Executors.newCachedThreadPool();

        final Semaphore semaphore=new Semaphore(threadTotal);

        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);

        for (int i = 0; i <clientTotal ; i++) {
            final int count=i;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    addTolist(count);
                    semaphore.release();
                }catch (Exception e){
                    log.error("execption",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",list.size());
    }

    private static void addTolist(int i){
        list.add(i);
    }
}
