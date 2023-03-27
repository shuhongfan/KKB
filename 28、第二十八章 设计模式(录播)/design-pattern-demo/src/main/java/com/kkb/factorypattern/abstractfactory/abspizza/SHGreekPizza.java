package com.kkb.factorypattern.abstractfactory.abspizza;


public class SHGreekPizza extends Pizza {

    @Override
    public void prepare() {

        setName("上海的希腊披萨");
        System.out.println("上海的希腊披萨正在准备原材料");
    }
}
