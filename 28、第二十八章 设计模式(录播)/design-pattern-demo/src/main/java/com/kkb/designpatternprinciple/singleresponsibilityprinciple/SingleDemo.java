package com.kkb.designpatternprinciple.singleresponsibilityprinciple;

/**
 * @Classname SingleDemo
 * @Created by 寂然
 * @Description 演示单一职责原则
 */
public class SingleDemo {

    public static void main(String[] args) {

        new Animal().runForest("老虎");
        new Animal().runForest("狮子");
        new Animal().flyAir("老鹰");

        //方案一
        /*new ForestAnimal().run("老虎");
        new ForestAnimal().run("狮子");
        new ForestAnimal().run("老狼");
        new AirAnimal().fly("老鹰");*/
    }
}
//需求：有一个动物类，里面定义一个在森林奔跑的方法，创建动物的实例，调用方法，方法内执行打印操作

class Animal{

    //森林奔跑的方法
    public void runForest(String animal){

        System.out.println(animal + "在森林里愉快的奔跑");

    }

    //天空飞翔的方法
    public void flyAir(String animal){

        System.out.println(animal + "在天空里愉快的飞翔");

    }
}

/*class ForestAnimal{

    public void run(String animal){

        System.out.println(animal + "在森林里愉快的奔跑");

    }
}

class AirAnimal{

    public void fly(String animal){

        System.out.println(animal + "在天空中愉快的飞翔");

    }
}*/


