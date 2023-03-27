package com.kkb.factorypattern.abstractfactory.abspizza;


public class BJGreekPizza extends Pizza {

    @Override
    public void prepare() {

        setName("北京的希腊披萨");
        System.out.println("北京的希腊披萨正在准备原材料");
    }
}
