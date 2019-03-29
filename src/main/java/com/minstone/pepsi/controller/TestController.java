package com.minstone.pepsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Describe 类描述，功能介绍
 * @Author chenlu
 * @Version V1.0
 * @Date 2019/1/24.
 */
@Controller
public class TestController {
    @RequestMapping("test")
    public String test(String name) {
        if (name != null) {
            System.out.println(name);

        }


        return "hello.jsp";
    }

    @RequestMapping("test1")
    @ResponseBody
    public Map<String, Object> test1(String name) {
        if (name != null) {
            System.out.println(name);

        }

        Map map = new HashMap();
        map.put("test", name);
        return map;
    }

    public static void main(String[] args) {

        TreeSet treeSet=new TreeSet();
        long time0 = System.currentTimeMillis();
        Integer[] array = getArray(100000);
//        toString(array);
        long time1=System.currentTimeMillis();

        Integer[] array1=insertSort(array);
        long time2=System.currentTimeMillis();

        Integer[] array2 = selectSort(array);
        long time3=System.currentTimeMillis();

        Integer[] array3 = bubbleSort(array);
        long time4=System.currentTimeMillis();

        Integer[] array4 = sort(array, 0, array.length-1);
        long time5 = System.currentTimeMillis();
//        toString(array4);
//        toString(array);
//        Arrays.sort(array);
//        toString(array);
//        long time5=System.currentTimeMillis();
//        Integer[] array4 = quickSort(array);
//        long time5=System.currentTimeMillis();

        System.out.println(time1-time0);
        System.out.println("插入排序: " + (time2-time1));
        System.out.println("选择排序: " + (time3-time2));
        System.out.println("冒泡排序: " + (time4-time3));
        System.out.println("快速排序: " + (time5-time4));

    }


    public static Integer[] sort2(Integer[] a,int low,int high){

        int start = low;
        int end = high;
        int key = a[low];

        while(end>start){
            //从后往前比较
            // 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
            while(end>start&&a[end]>=key){
                end--;
            }

            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            // 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
            while(end>start&&a[start]<=key) {
                start++;
            }
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }

        //递归
        if(start>low) sort2(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1

        if(end<high) sort2(a,end+1,high);//右边序列。从关键值索引+1到最后一个
//        toString(a);
        return a;
    }



    public static int partition(Integer[] array, int from, int to) {
        //三数取中
        int mid = from + (to - from) / 2;
        if (array[mid] > array[to]) {
            swap(array[mid], array[to]);
        }
        if (array[from] > array[to]) {
            swap(array[from], array[to]);
        }
        if (array[mid] > array[from]) {
            swap(array[mid], array[from]);
        }
        int key = array[from];

        while (from < to) {
            while (array[to] >= key && to > from) {
                to--;
            }
            array[from] = array[to];
            while (array[from] <= key && to > from) {
                from++;
            }
            array[to] = array[from];
        }
        array[to] = key;
        return to;
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static Integer[] sort(Integer[] array, int from, int to) {
        if (from >= to) {
            return new Integer[0];
        }
        int index = partition(array, from, to);
        sort(array, from, index - 1);
        sort(array, index + 1, to);
        return array;
    }

    /**
     * 3、快速排序
     *
     * @param array
     * @return
     */
    public static Integer[] quickSort(Integer[] array, Integer i, Integer j) {

        int key = array[i];
        int s=i;
        int e=j;
        while (e>s){
            while (e>s&&key<=array[e]){
                e--;
            }

            if(key>=array[e]) {
                int temp = array[e];
                array[e] = array[s];
                array[s] = temp;

            }
            while (e>s&&key>=array[s]){
                s++;
            }
            if(key<=array[s]){
                int temp = array[s];
                array[s] = array[e];
                array[e] = temp;

            }
        }

        if(s>i)quickSort(array,i,s-1);
        if(j>e)quickSort(array,e+1,j);
//        toString(array);
        return array;
    }


    /**
     * 3、冒泡排序
     *
     * @param array
     * @return
     */
    public static Integer[] bubbleSort(Integer[] array) {
        int k = array.length;
        int temp;
        for (int i = 0; i < k; i++) {
            for (int j = k - 2; j >= i; j--) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
//        toString(array);
        return array;
    }

    /**
     * 2、直接选择排序
     *
     * @param array
     * @return
     */
    public static Integer[] selectSort(Integer[] array) {
        int k;
        int temp;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            k = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[k] > array[j]) {
                    k = j;
                }
            }
            array[i] = array[k];
            array[k] = temp;
        }
//        toString(array);
        return array;
    }


    /**
     * 1、直接插入排序
     *
     * @param array
     * @return
     */
    public static Integer[] insertSort(Integer[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
//        toString(array);
        return array;
    }

    /**
     * 直接插入排序
     *
     * @param list
     * @return
     */
    public static List<Integer> directSequence(List<Integer> list) {
        int temp;
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (temp < list.get(j)) {
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }


    public static void toString(Integer[] array) {
        System.out.println("========================");
        System.out.print("数组：");
        for (Integer i : array) {
            System.out.print(i + "、");
        }
        System.out.println();
    }

    public static void toString2(List<Integer> list) {
        System.out.println("========================");
        System.out.print("数组：");
        for (Integer i : list) {
            System.out.print(i + "、");
        }
        System.out.println();
    }

    public static Integer[] getArray(int n) {
        Random random = new Random();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (n * random.nextFloat());
        }
        return array;
    }

    public static List<Integer> getList(int n) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add((int) (1000 * random.nextFloat()));
//            System.out.print(i+"==="+list.get(i));
        }
        return list;
    }

    public static void test2(String a) {
        switch (a) {
            case "A":
                System.out.println("我是A");
                break;
            case "B":
                System.out.println("我是B");
                break;
            case "C":
                System.out.println("我是C");
                break;
            default:
                System.out.println("我啥也不是");
        }

    }

}
