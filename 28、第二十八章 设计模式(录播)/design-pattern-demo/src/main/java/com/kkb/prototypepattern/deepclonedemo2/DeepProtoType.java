package com.kkb.prototypepattern.deepclonedemo2;

import java.io.Serializable;

public class DeepProtoType implements Serializable, Cloneable {

    public String name; //String类型

    public DeepCloneableTarget deepCloneableTarget; //引用类型

    public DeepProtoType() {
        super();
    }

    //深拷贝 - 方式一：重写clone方法  级联

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Object deep = null;

        //这里完成的是对基本数据类型以及String类型的拷贝
        deep = super.clone();

        //对引用类型的属性进行单独处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;

        deepProtoType.deepCloneableTarget= (DeepCloneableTarget) deepCloneableTarget.clone();

        deepProtoType.deepCloneableTarget.witness = (Witness) deepProtoType.deepCloneableTarget.witness.clone();

        return deepProtoType;
    }

    @Override
    public String toString() {
        return "DeepProtoType{" +
                "name='" + name + '\'' +
                ", deepCloneableTarget=" + deepCloneableTarget +
                '}';
    }
}
