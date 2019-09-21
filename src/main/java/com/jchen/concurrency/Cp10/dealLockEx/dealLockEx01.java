package com.jchen.concurrency.Cp10.dealLockEx;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class dealLockEx01 implements Runnable{
    public int flag =1;


    private static Object o1=new Object(),o2=new Object();




    @Override
    public void run() {
        log.info("flag:{}",flag);

        if(flag==1){
            synchronized (o1){
                try{
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (o2){
                    log.info("1");
                }
            }
        }
        if(flag==0){
            synchronized (o2){
                try{
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }

                synchronized (o1){
                    log.info("0");
                }

            }
        }
    }

    public static void main(String[] args) {
        dealLockEx01 ex1=new dealLockEx01();
        ex1.flag=1;
        dealLockEx01 ex0=new dealLockEx01();
        ex0.flag=0;

        new Thread(ex1).start();
        new Thread(ex0).start();

    }
}
