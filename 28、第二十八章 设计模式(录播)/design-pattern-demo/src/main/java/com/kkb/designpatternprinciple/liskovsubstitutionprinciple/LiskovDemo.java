package com.kkb.designpatternprinciple.liskovsubstitutionprinciple;

//案例演示 - 里氏替换原则
public class LiskovDemo {
    public static void main(String[] args) {

        int result = new Calculator().add(3, 5);
        System.out.println(result);

        int mul = new SuperCalculator().mul(3, 5);
        System.out.println("两数相加之和与100求差的值为" + mul);

    }
}

//需求：现在有一个计算器（父类）可以完成加减乘除，定义其子类，来演示继承可能出现的问题

//创建一个更加基础的基类（定义更加基础的成员或者功能）

class Base{

    //TODO....

}


class Calculator extends Base{

    //定义加法功能
    public int add(int a,int b){

        return a + b;
    }

    //定义减法功能
    public int sub(int a,int b){

        return a - b;
    }

    //TODO...
}


class SuperCalculator extends Base{

    //变为依赖关系
    private Calculator calculator = new Calculator();


    //增补需求，两数相加再加5

    public int add(int a,int b){

        return a + b + 5;
    }

    //希望两数相加之和与100求差
    public int mul(int a,int b){

        int count = calculator.add(a, b);

        return 100 - count;

    }


}