package com.kkb.factorypattern.simplefactory.pizza;

/**
 * @Classname Pizza
 * @Created by 寂然
 * @Description 抽象基类
 */
public abstract class Pizza {

    private String name; //披萨的名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //抽象方法
    public abstract void prepare();

    //烘焙
    public void bake() {

        System.out.println(name + "正在烘焙中 ------ ");
    }

    //切割
    public void cut() {

        System.out.println(name + "正在被厨师大卸八块");
    }

    //打包
    public void box() {

        System.out.println(name + "正在被服务生打包");
    }

}
