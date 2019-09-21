package com.jchen.concurrency.Cp07.lockEx;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ConditionEx {
    public static void main(String[] args) throws Exception{
        ReentrantLock reentrantLock=new ReentrantLock();

        Condition condition=reentrantLock.newCondition();

        new Thread(()->{
            try {
                reentrantLock.lock();
                log.info("wait signal");
                condition.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            log.info("get　singal");
            reentrantLock.unlock();
        }).start();

        new Thread(()->{
            reentrantLock.lock();
            log.info("get lock");
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            condition.signalAll();
            log.info("send singal ~");
            reentrantLock.unlock();
        }).start();
    }
}
