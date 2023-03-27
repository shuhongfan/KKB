package com.kkb.prototypepattern.deepclonedemo1;

public class DeepProtoType implements Cloneable{

    public String name; //String类型

    public DeepCloneableTarget deepCloneableTarget; //引用类型  ???

    public DeepProtoType() {
        super();
    }

    //完成深拷贝
    //实现方式一：重写clone方法


    @Override
    protected Object clone() throws CloneNotSupportedException {

        //要拷贝的对象
        Object deep = null;

        //分布进行
        //完成对于基本数据类型或者String类型的拷贝
        deep = super.clone();

        //对引用类型进行处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;

        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();


        return deepProtoType;
    }
}
