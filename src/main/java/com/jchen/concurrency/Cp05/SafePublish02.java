package com.jchen.concurrency.Cp05;


import com.jchen.concurrency.annoations.NotThreadSafe;
import com.jchen.concurrency.annoations.ThreadSafe;

/**
 * 饿汉模式，类转载的时候出现
 * 不足，会导致加载速度过慢，构造函数过多
 */
@ThreadSafe
public class SafePublish02 {
    private SafePublish02(){

    }
    private static SafePublish02 instance=new SafePublish02();

    //静态工厂方法，多线程方式会出问题
    public static SafePublish02 getInstance(){
        return instance;
    }

    


}
