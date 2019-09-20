package com.jchen.concurrency.Cp05;


import com.jchen.concurrency.annoations.Recommend;
import com.jchen.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式,线程安全，双重锁
 * 限制指令重排，原因见04
 * 添加volatile+双重检测机制
 */
@ThreadSafe
@Recommend
public class SafePublish05 {
    private SafePublish05(){

    }
    private static volatile SafePublish05 instance=null;
//    理想步骤
    //分配空间
    //初始化对象
    //设置instance指向刚分配的内存

    //jvm 和cpu优化，发生了指令重排

    //分配空间
    //设置instance指向刚分配的内存
    //初始化对象



    //静态工厂方法
    public static SafePublish05 getInstance(){
        if (instance==null){//双重检测机制
            synchronized (SafePublish05.class) {//同步锁
                if(instance==null){
                instance = new SafePublish05();
                }
            }
        }
        return instance;
    }

}
