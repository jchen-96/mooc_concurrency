package com.jchen.concurrency.Cp05;

//使用枚举进行初始化，是十分安全的
//懒汉模式

import com.jchen.concurrency.annoations.ThreadSafe;

@ThreadSafe
public class SafePublish07 {

    private SafePublish07(){

    }

    public static SafePublish07 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SafePublish07 safePublish7;


        //JVM保证这个方法只被调用一次
        Singleton(){
            safePublish7=new SafePublish07();
        }

        public SafePublish07 getInstance(){
            return safePublish7;
        }
    }
}
