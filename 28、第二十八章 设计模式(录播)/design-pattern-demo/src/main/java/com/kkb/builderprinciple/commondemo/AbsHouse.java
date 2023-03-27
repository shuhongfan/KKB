package com.kkb.builderprinciple.commondemo;

public abstract class AbsHouse {

    private String basic; //地基

    private String wall; //墙

    private String roofed; //屋顶

    //筑基
    public abstract void buildBasic();

    //砌墙
    public abstract void buildWalls();

    //封顶
    public abstract void roofed();

}
