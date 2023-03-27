package com.kkb.factorypattern.simplefactory.order;

import com.kkb.factorypattern.simplefactory.pizza.CheesePizza;
import com.kkb.factorypattern.simplefactory.pizza.FruitPizza;
import com.kkb.factorypattern.simplefactory.pizza.GreekPizza;
import com.kkb.factorypattern.simplefactory.pizza.Pizza;

/**
 * @Classname SimpleFactory
 * @Created by 寂然
 * @Description 简单工厂类
 */
public class SimpleFactory {

    //创建对象的方法
    public static Pizza createPizza(String orderType){

        Pizza pizza = null;

        //按需创建披萨的业务逻辑

        if (orderType.equals("GreekPizza")){

            pizza = new GreekPizza();

            pizza.setName("GreeKPizza");
        } else if (orderType.equals("FruitPizza")){

            pizza = new FruitPizza();

            pizza.setName("FruitPizza");
        } else if (orderType.equals("CheesePizza")){

            pizza = new CheesePizza();

            pizza.setName("CheesePizza");
        }

        return pizza;

    }
}
