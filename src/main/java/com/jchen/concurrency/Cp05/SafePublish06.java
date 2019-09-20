package com.jchen.concurrency.Cp05;


import com.jchen.concurrency.annoations.ThreadSafe;

/**
 * 饿汉模式，类转载的时候出现
 * 不足，会导致加载速度过慢，构造函数过多
 */
@ThreadSafe
public class SafePublish06 {
    private SafePublish06(){

    }
    private static SafePublish06 instance=null;


    static {
        instance=new SafePublish06();
    }

    //静态代码块的顺序需要格外注意

    //静态工厂方法，多线程方式会出问题
    public static SafePublish06 getInstance(){
        return instance;
    }


    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }

    


}
