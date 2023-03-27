package com.kkb.builderprinciple.commondemo;

public class HighBuilding extends AbsHouse {


    @Override
    public void buildBasic() {


        System.out.println("高楼正在筑基 ---- ");
    }

    @Override
    public void buildWalls() {

        System.out.println("高楼正在砌墙 ---- ");

    }

    @Override
    public void roofed() {

        System.out.println("高楼正在封顶 ---- ");

    }
}
