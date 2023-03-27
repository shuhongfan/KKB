package com.kkb.singletonpattern.doublecheckdemo;

//案例演示 - 双重检查机制来实现单例模式
public class DoubleCheckDemo {

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


    //禁止指令重排
    private static volatile Singleton singleton;

    //加入双重检查机制
    public static Singleton getInstance(){
        if (singleton == null){

            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}