package com.jchen.concurrency.Cp05;


import com.jchen.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉模式
 * 多线程方式下会出现问题
 */
@NotThreadSafe
public class SafePublish01 {
    private SafePublish01(){

    }
    private static SafePublish01 instance=null;

    //静态工厂方法，多线程方式会出问题
    public static SafePublish01 getInstance(){
        if (instance==null){
            instance=new SafePublish01();
        }
        return instance;
    }




}
