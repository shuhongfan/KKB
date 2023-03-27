package com.kkb.factorypattern.simplefactory.order;

import com.kkb.factorypattern.simplefactory.pizza.Pizza;

import java.util.Scanner;

/**
 * @Classname OrderPizza
 * @Created by 寂然
 * @Description 订购披萨的业务逻辑 调用方
 */
public class OrderPizza {

    SimpleFactory simpleFactory;

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;

        while (true){

            orderType = getType();

            pizza = this.simpleFactory.createPizza(orderType);

            if (pizza != null){//订购成功

                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();

            } else {

                System.out.println("抱歉，这里没有你想要的披萨");
                break;
            }
        }


    }

    Pizza pizza = null;

    String orderType; //订购披萨的类型

    public OrderPizza(SimpleFactory simpleFactory){

        setSimpleFactory(simpleFactory);
    }


    //获取客户希望的披萨类型
    public String getType(){

        System.out.println("请输入你要订购的披萨类型");

        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        return next;
    }
}
