package com.kkb.factorypattern.abstractfactory.absorder;

import com.kkb.factorypattern.abstractfactory.abspizza.BJFruitPizza;
import com.kkb.factorypattern.abstractfactory.abspizza.BJGreekPizza;
import com.kkb.factorypattern.abstractfactory.abspizza.Pizza;


public class BJFactory implements AbsFactory{

    @Override
    public Pizza createPizza(String orderType) {

        Pizza pizza = null;

        if (orderType.equals("GreekPizza")){

            pizza = new BJGreekPizza();

        }else if (orderType.equals("FruitPizza")){

            pizza = new BJFruitPizza();
        }

        return pizza;
    }
}
