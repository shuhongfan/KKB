package com.kkb.factorypattern.abstractfactory.absorder;

import com.kkb.factorypattern.abstractfactory.abspizza.Pizza;

import java.util.Scanner;


public class OrderPizza {


    AbsFactory absFactory;

    public OrderPizza(AbsFactory absFactory){

        setAbsFactory(absFactory);

    }

    public void setAbsFactory(AbsFactory absFactory) {

        Pizza pizza = null;

        String orderType = ""; //用户输入

        this.absFactory = absFactory;

        while (true){

            orderType = getType();

            pizza = absFactory.createPizza(orderType);

            if (pizza != null){  //订购成功，输出制作过程

                pizza.prepare();

                pizza.bake();

                pizza.cut();

                pizza.box();

            } else{

                System.out.println("订购失败，咱这没有，去别处把");

                break;
            }

        }


    }

    //定义方法获取客户希望订购的披萨种类
    private String getType(){

        System.out.println("你想订购那个种类的Pizza呢？");

        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        return str;
    }
}
