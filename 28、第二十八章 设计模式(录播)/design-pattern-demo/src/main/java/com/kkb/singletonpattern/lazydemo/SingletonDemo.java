package com.kkb.singletonpattern.lazydemo;

//案例演示 - 懒汉式
public class SingletonDemo {
    public static void main(String[] args) {

        /*Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1); //true
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());*/

    }
}

//加入同步处理  同步方法
/*
class Singleton{

    //构造器私有化
    private Singleton(){}

    //类的内部提供对象
    private static Singleton singleton;

    //对外提供公共的静态方法的时候，来判断
    public static synchronized Singleton getInstance(){

        if (singleton == null){

            singleton = new Singleton();
        }

        return singleton;
    }

}*/

//加入同步处理 - 同步代码块的方式  不推荐的
class Singleton{

    //构造器私有化
    private Singleton(){}

    //类的内部提供对象
    private static Singleton singleton;

    //对外提供公共的静态方法的时候，来判断
    public static Singleton getInstance(){

        if (singleton == null){

            synchronized (Singleton.class){

                singleton = new Singleton();
            }

        }

        return singleton;
    }

}