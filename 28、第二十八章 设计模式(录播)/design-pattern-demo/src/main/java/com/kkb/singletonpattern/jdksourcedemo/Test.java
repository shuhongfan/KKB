package com.kkb.singletonpattern.jdksourcedemo;

//使用一下Runtime类
public class Test {

    public static void main(String[] args) {

        //使用相应的获取对象的方法来初始化对象
        Runtime runtime = Runtime.getRuntime();
        int processors = runtime.availableProcessors();
        long maxMemory = runtime.maxMemory();
        long freeMemory = runtime.freeMemory();
        //....

        System.out.println("处理器的个数是" + processors);
        System.out.println("空闲内存是" + freeMemory);
        System.out.println("最大内存是" + maxMemory);
    }
}
