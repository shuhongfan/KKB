package com.kkb.factorypattern.simplefactory.pizza;

/**
 * @Classname CheesePizza
 * @Created by 寂然
 * @Description 芝士披萨
 */
public class CheesePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("准备芝士披萨的原材料");
    }
}
