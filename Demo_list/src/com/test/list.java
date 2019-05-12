package com.test;

import org.junit.Test;
import java.util.*;
import java.util.stream.Collectors;

public class list {
    //方法一:使用java8新特性stream进行List去重
    @Test
    public void demo1() {
        List list=new ArrayList();
        list.add(11);
        list.add(12);
        list.add(9);
        list.add(10);
        list.add(10);
        System.out.println(list);
        List newList = (List) list.stream().distinct().collect(Collectors.toList());
        System.out.println("java8新特性stream: "+newList);
    }
    //方法二:双重for循环去重
    @Test
    public void demo2() {
        List list=new ArrayList();
        list.add(11);
        list.add(12);
        list.add(9);
        list.add(10);
        list.add(10);
        Collections.sort(list);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(i!=j && list.get(i)==list.get(j)) {
                    list.remove(list.get(j));
                    System.out.println("双重for循环去重: "+list);
                }
            }
        }
    }
    //方法三:set集合判断去重,不打乱顺序
    @Test
    public void demo3() {
        List list=new ArrayList();
        list.add(11);
        list.add(12);
        list.add(9);
        list.add(10);
        list.add(10);
        Collections.sort(list);
        System.out.println(list);
        Set set=new HashSet();
        List newList=new ArrayList();
        for (Object obj : list) {
            if(set.add(obj)) {
                newList.add(obj);
            }
        }
        System.out.println("set集合判断去重: "+newList);
    }
    //方法四:遍历后判断赋给另一个list集合
    @Test
    public void demo4() {
        List list=new ArrayList();
        list.add(11);
        list.add(12);
        list.add(9);
        list.add(10);
        list.add(10);
        Collections.sort(list);
        System.out.println(list);
        List newList=new ArrayList();
        for (Object obj : list) {
            if(!newList.contains(obj)) {
                newList.add(obj);
            }
        }
        System.out.println("遍历后判断赋给另一个list集合 : "+newList);
    }
    //方法五:set和list转换去重
    @Test
    public void demo5() {
        List list=new ArrayList();
        list.add(11);
        list.add(12);
        list.add(9);
        list.add(10);
        list.add(10);
        Collections.sort(list);
        System.out.println(list);
        Set set=new HashSet();
        List newList=new ArrayList();
        set.addAll(list);
        newList.addAll(set);
        System.out.println("set和list转换去重 : "+newList);
    }
}
