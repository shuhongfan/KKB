package com.kkb.factorypattern.abstractfactory.absorder;

import com.kkb.factorypattern.abstractfactory.abspizza.Pizza;


public interface AbsFactory {


    public Pizza createPizza(String orderType);

}
