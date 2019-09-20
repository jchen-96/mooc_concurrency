package com.jchen.concurrency.Cp04.sync;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//如果这个类是父类，则在子类中sync效果消失

@Slf4j
public class syncEx01 {

    //修饰一个代码块,如果修饰的是一个方法里面的所有代码，则和直接修饰方法的效果等同
    public void test(){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                log.info("test1-{}",i);
            }
        }
    }
    //修饰方法
    public synchronized void test2(){
        for (int i = 0; i <10 ; i++) {
            log.info("test2-{}",i);
        }
    }


    public static void main(String[] args) {
        syncEx01 s1 = new syncEx01();
        syncEx01 s2 = new syncEx01();

        ExecutorService executorService = Executors.newCachedThreadPool();


//        executorService.execute(()->{
//            s1.test();
//        });
//
//        executorService.execute(()->{
//            s1.test();
//        });
//
//
//        executorService.execute(()->{
//            s1.test2();
//        });
//
//        executorService.execute(()->{
//            s1.test2();
//        });


//        不同实例互不影响

        executorService.execute(()->{
            s1.test2();
        });

        executorService.execute(()->{
            s2.test2();
        });



        executorService.shutdown();
    }

}
