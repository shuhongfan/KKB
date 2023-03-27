package com.kkb.singletonpattern.hungrydemo;

//案例演示 - 饿汉式
public class SingletonDemo {

    public static void main(String[] args) {

//      方式一：静态常量
        /*SingletonDemo instance = SingletonDemo.getInstance();
        SingletonDemo instance1 = SingletonDemo.getInstance();
        System.out.println(instance == instance1); //true
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());*/

        //方式二：静态代码块
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1); //true
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }
}


/*
//方式一  静态常量
class SingletonDemo{

    //一：构造器的私有化 防止外部用构造器...
    private SingletonDemo(){}

    //二：类的内部创建对象 final static
    private static final SingletonDemo singleton = new SingletonDemo();

    //三：对外提供公共的静态方法 返回该类唯一的对象实例
    public static SingletonDemo getInstance(){

        return singleton;
    }
}
*/

//方式二：静态代码块的方式
class Singleton{

    //构造器私有化
    private Singleton(){}

    //类的内部创建对象
    private static final Singleton singleton;

    static {
        singleton = new Singleton();
    }

    //对外提供公共的静态的方法
    public static Singleton getInstance(){

        return singleton;
    }
}