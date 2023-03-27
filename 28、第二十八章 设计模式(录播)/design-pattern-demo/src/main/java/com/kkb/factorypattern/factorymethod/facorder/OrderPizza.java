package com.kkb.factorypattern.factorymethod.facorder;

import com.kkb.factorypattern.factorymethod.facpizza.Pizza;

import java.util.Scanner;

/**
 * @Classname OrderPizza
 * @Created by 寂然
 * @Description I walk very slowly, but I never walk backwards
 */
public abstract class OrderPizza {


    public abstract Pizza createPizza(String orderType);

    public OrderPizza(){

        Pizza pizza = null;

        String orderType = "";

        while (true){

            orderType = getType();

            pizza = createPizza(orderType);

            if (pizza!= null){

                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }

        }
    }

    //客户希望订购的披萨类型
    public String getType() {

        System.out.println("请问你需要订购什么类型的披萨呢");

        Scanner scanner = new Scanner(System.in);

        String next = scanner.next();

        return next;
    }
}
