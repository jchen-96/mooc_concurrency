package com.jchen.concurrency.Cp06.collectionExs;

import com.jchen.concurrency.annoations.NotThreadSafe;

import java.util.Vector;


@NotThreadSafe
public class VectorEx {
    private static Vector<Integer> vector=new Vector<>();

    public static void main(String[] args) {
        while (true) {

            for (int i = 0; i < 10; i++) {
            vector.add(i);
            }
            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };
            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };
            thread1.start();
            thread2.start();
        }
    }

//    两个同步方法因为顺序不同导致的，同步容器并不是所有场合都线程安全
}
