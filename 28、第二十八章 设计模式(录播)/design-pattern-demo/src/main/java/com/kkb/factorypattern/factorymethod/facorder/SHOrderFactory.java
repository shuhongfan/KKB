package com.kkb.factorypattern.factorymethod.facorder;

import com.kkb.factorypattern.factorymethod.facpizza.Pizza;
import com.kkb.factorypattern.factorymethod.facpizza.SHFruitPizza;
import com.kkb.factorypattern.factorymethod.facpizza.SHGreekPizza;

/**
 * @Classname SHOrderFactory
 * @Created by 寂然
 * @Description 上海的工厂子类
 */
public class SHOrderFactory extends OrderPizza {
    @Override
    public Pizza createPizza(String orderType) {

        Pizza pizza = null;

        if (orderType.equals("GreekPizza")){

            pizza = new SHGreekPizza();
        } else if (orderType.equals("FruitPizza")){

            pizza = new SHFruitPizza();
        }

        return pizza;
    }
}
