package com.jchen.concurrency.Cp06.concurrencyCollection;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;


@Slf4j
public class CopyOnWriteArrayListEx {
    public static int clientTotal=5000;

    public static int threadTotal=200;

    private static CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<>();




    public static void main(String[] args) throws Exception{
        ExecutorService executorService= Executors.newCachedThreadPool();

        final Semaphore semaphore=new Semaphore(threadTotal);

        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);

        for (int i = 0; i <clientTotal ; i++) {
            final int count=i;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    concurrentList(count);
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

    private static void concurrentList(int i){
        list.add(i);
    }
}
