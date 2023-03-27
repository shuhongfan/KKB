package com.kkb.factorypattern.abstractfactory.abspizza;


public class SHFruitPizza extends Pizza {

    @Override
    public void prepare() {

        setName("上海的水果披萨");
        System.out.println("上海的水果披萨正在准备原材料");
    }
}
