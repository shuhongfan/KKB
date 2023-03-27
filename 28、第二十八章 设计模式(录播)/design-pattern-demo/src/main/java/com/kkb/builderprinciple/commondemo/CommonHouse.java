package com.kkb.builderprinciple.commondemo;

//普通房屋
public class CommonHouse extends AbsHouse {
    @Override
    public void buildBasic() {

        System.out.println("普通房屋正在筑基 ---- ");
    }

    @Override
    public void buildWalls() {

        System.out.println("普通房屋正在砌墙 ---- ");
    }

    @Override
    public void roofed() {

        System.out.println("普通房屋正在封顶 ---- ");

    }
}
