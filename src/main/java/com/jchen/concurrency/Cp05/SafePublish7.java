package com.jchen.concurrency.Cp05;

//使用枚举进行初始化，是十分安全的
//懒汉模式

import com.jchen.concurrency.annoations.ThreadSafe;

@ThreadSafe
public class SafePublish7 {

    private SafePublish7(){

    }

    public static SafePublish7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SafePublish7 safePublish7;


        //JVM保证这个方法只被调用一次
        Singleton(){
            safePublish7=new SafePublish7();
        }

        public SafePublish7 getInstance(){
            return safePublish7;
        }
    }
}
