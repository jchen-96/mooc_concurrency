package com.jchen.concurrency.Cp05;


import com.jchen.concurrency.annoations.NotRecommend;
import com.jchen.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thiscanBeescape=0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass(){
            log.info("{}",Escape.this.thiscanBeescape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
