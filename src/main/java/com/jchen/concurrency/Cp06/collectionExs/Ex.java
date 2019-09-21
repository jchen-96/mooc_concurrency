package com.jchen.concurrency.Cp06.collectionExs;

import java.util.Iterator;
import java.util.Vector;

public class Ex {

//    使用迭代器和foreach 遍历过程中，不要在操作过程中对集合进行修改
//    建议在遍历完之后，标记，然后在进行修改


    //error
    private static void test1(Vector<Integer> v1){
        for(Integer i:v1){
            if(i.equals(3)){
                v1.remove(i);
            }
        }
    }

    //error
    private static void test2(Vector<Integer> v1){
        Iterator<Integer> iterator=v1.iterator();
        while (iterator.hasNext()){
            Integer i=iterator.next();
            if(i.equals(3)){
                v1.remove(i);
            }
        }
    }

    //正常的
    private static void test3(Vector<Integer> v1){
        for (int i = 0; i <v1.size() ; i++) {
            if(v1.get(i).equals(i)){
                v1.remove(i);
            }
        }
    }


    public static void main(String[] args) {
        Vector<Integer> vector=new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3(vector);

    }
}
