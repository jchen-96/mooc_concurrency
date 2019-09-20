package com.jchen.concurrency.Cp06.threadLocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder=new ThreadLocal<>();
    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    public static void remove(){
//       threadLocal　要移除，不然内存泄露
        requestHolder.remove();
    }


}
