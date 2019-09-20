package com.jchen.concurrency.Cp06;

import com.google.common.collect.Maps;
import com.jchen.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;


@Slf4j
@ThreadSafe
public class ImmutableEx02 {



    private  static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);

//        通过unmodifiable包装
        map= Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {

        map.put(1, 3);
        log.info("{}", map.get(1));//值不能修改


    }

}
