package com.jchen.concurrency.Cp04;

import com.jchen.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicExample05 {
    private static AtomicIntegerFieldUpdater<AtomicExample05> updater=
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample05.class,"count");

    @Getter
    public volatile int count=100;


    public static void main(String[] args) {

        AtomicExample05 example05=new AtomicExample05();

        if(updater.compareAndSet(example05,100,120)){
            log.info("updata success,{}",example05.getCount());
        }else{
            log.info("update failed,{}",example05.getCount());
        }

        if(updater.compareAndSet(example05,100,120)){
            log.info("updata success2,{}",example05.getCount());
        }else{
            log.info("update failed2,{}",example05.getCount());
        }
    }
}
