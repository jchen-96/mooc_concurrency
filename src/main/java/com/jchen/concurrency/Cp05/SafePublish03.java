package com.jchen.concurrency.Cp05;


import com.jchen.concurrency.annoations.NotRecommend;
import com.jchen.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式的线程安全
 * 多线程方式下会出现问题
 */
@ThreadSafe
@NotRecommend
public class SafePublish03 {
    private SafePublish03(){

    }
    private static SafePublish03 instance=null;

    //静态工厂方法，多线程方式会出问题
    public static synchronized SafePublish03 getInstance(){
        if (instance==null){
            instance=new SafePublish03();
        }
        return instance;
    }

    //不建议这样写，这样会导致在后续获取实例的速度过慢





}
