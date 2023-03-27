package com.kkb.builderprinciple.commondemo;

//普通方案 - 工程需求
//客户端
public class CommonDemo {

    public static void main(String[] args) {


        new CommonHouse().buildBasic();

        new CommonHouse().buildWalls();

        new CommonHouse().roofed();

        new HighBuilding().roofed();

        new HighBuilding().buildBasic();

        new HighBuilding().buildWalls();

    }
}




