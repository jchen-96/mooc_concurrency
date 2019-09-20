package com.jchen.concurrency.Cp04.sync;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class syncEx02 {

    //修饰静态方法
    public static synchronized void test2(){
        for (int i = 0; i <10 ; i++) {
            log.info("test-{}",i);
        }
    }

    //修饰一个类,和静态方法表现一致

    public static void test(){
        synchronized (syncEx02.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test-{}", i);
            }
        }
    }


    public static void main(String[] args) {

        syncEx02 s1=new syncEx02();
        syncEx02 s2=new syncEx02();

        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(()->{
            s1.test2();
        });
        executorService.execute(()->{
            s2.test2();
        });


    }
}
