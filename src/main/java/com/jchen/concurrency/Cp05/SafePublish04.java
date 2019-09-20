package com.jchen.concurrency.Cp05;


import com.jchen.concurrency.annoations.NotRecommend;
import com.jchen.concurrency.annoations.NotThreadSafe;
import com.jchen.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式的线程不安全，双重锁
 */
@NotThreadSafe
@NotRecommend
public class SafePublish04 {
    private SafePublish04(){

    }
    private static SafePublish04 instance=null;
//    理想步骤
    //分配空间
    //初始化对象
    //设置instance指向刚分配的内存

    //jvm 和cpu优化，发生了指令重排

    //分配空间
    //设置instance指向刚分配的内存
    //初始化对象



    //静态工厂方法
    public static SafePublish04 getInstance(){
        if (instance==null){//双重检测机制
            synchronized (SafePublish04.class) {//同步锁
                if(instance==null){
                instance = new SafePublish04();
                }
            }
        }
        return instance;
    }

}
