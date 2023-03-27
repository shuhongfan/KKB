package com.kkb.singletonpattern.enumdemo;

//案例演示 - 枚举方式来实现单例模式
public class EnumDemo {
    public static void main(String[] args) {

        //验证其正确性
        Singleton instance = Singleton.INSTANCE;
        Singleton instance1 = Singleton.INSTANCE;
        System.out.println(instance == instance1); //true
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());

    }
}

enum Singleton{

    INSTANCE; //属性
}

