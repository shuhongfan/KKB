package com.kkb.singletonpattern.innerclassdemo;

//案例演示 - 静态内部类
public class InnerClassDemo {

    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1); //true
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());

    }
}

class Singleton{

    private Singleton(){}

    private static class SingletonInstance{

        public static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){

        return SingletonInstance.INSTANCE;
    }
}