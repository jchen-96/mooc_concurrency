package com.jchen.concurrency.Cp05;


import com.jchen.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
public class UnsafePublish {
    private String[] states={"a","b","c"};

    public String[] getStates(){
//        这样的发布对象是不安全的，因为是引用
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish=new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
        unsafePublish.getStates()[0]="d";

        log.info("{}", Arrays.toString(unsafePublish.getStates()));


    }




}
