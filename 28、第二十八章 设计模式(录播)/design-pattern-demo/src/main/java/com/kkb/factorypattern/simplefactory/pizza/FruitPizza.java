package com.kkb.factorypattern.simplefactory.pizza;

/**
 * @Classname FruitPizza
 * @Created by 寂然
 * @Description 水果披萨基类
 */
public class FruitPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("准备水果披萨的原材料");
    }
}
