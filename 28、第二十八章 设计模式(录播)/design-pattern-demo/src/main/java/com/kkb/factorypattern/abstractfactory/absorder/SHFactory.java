package com.kkb.factorypattern.abstractfactory.absorder;

import com.kkb.factorypattern.abstractfactory.abspizza.Pizza;
import com.kkb.factorypattern.abstractfactory.abspizza.SHFruitPizza;
import com.kkb.factorypattern.abstractfactory.abspizza.SHGreekPizza;


public class SHFactory implements AbsFactory{

    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;

        if (orderType.equals("GreekPizza")){

            pizza = new SHGreekPizza();

        }else if (orderType.equals("FruitPizza")){

            pizza = new SHFruitPizza();
        }

        return pizza;
    }
}
