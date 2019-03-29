package com.minstone.pepsi.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe 类描述，功能介绍
 * @Author chenlu
 * @Version V1.0
 * @Date 2019/2/28.
 */
public class Test {
    public static void main(String[] args) {
        Long s=System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        for(int i=0;i<10000;i++){
            list.add("测试==="+i);
        }
        String[] array=list.toArray(new String[list.size()]);
//        for (String a:array) {
//            System.out.println(a);
//        }
        System.out.println(array);
        Long e = System.currentTimeMillis();
        System.out.println(s);
        System.out.println(e);
        System.out.println(s-e);
    }
}
