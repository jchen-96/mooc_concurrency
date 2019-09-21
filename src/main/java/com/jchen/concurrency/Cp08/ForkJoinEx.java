package com.jchen.concurrency.Cp08;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;


@Slf4j
public class ForkJoinEx extends RecursiveTask<Integer> {
    public static final int threshold=2;

    private int start;
    private int end;

    public ForkJoinEx(int start,int end){
        this.start=start;
        this.end=end;
    }

    @Override
    protected Integer compute(){
        int sum=0;
        boolean canCompute=(end-start)<=threshold;
        if(canCompute){
            for (int i = start; i <=end; i++) {
                sum+=i;
            }
        }else {
            int mid=(end+start)/2;

            ForkJoinEx leftTask=new ForkJoinEx(start,mid);
            ForkJoinEx rightTask=new ForkJoinEx(mid+1,end);

            leftTask.fork();
            rightTask.fork();

            int leftResult=leftTask.join();
            int rightResult=rightTask.join();

            sum=leftResult+rightResult;


        }

        return sum;
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool=new ForkJoinPool();

        ForkJoinEx task=new ForkJoinEx(1,100);

        Future<Integer> result=forkJoinPool.submit(task);

        try{
            log.info("result:{}",result.get());
        }catch (Exception e){
            log.error("exception",e);
        }
    }
}
