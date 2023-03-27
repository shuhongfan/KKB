package com.kkb.factorypattern.factorymethod.facpizza;


public abstract class Pizza {


    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //准备原材料
    public abstract void prepare();

    //烘焙方法
    public void bake() {

        System.out.println(name + "正在烘焙中");
    }

    //切割方法
    public void cut() {

        System.out.println(name + "正准备把披萨大卸八块");
    }

    //打包方法
    public void box() {

        System.out.println(name + "将披萨打包给顾客");
    }
}
