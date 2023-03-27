package com.kkb.prototypepattern.deepclonedemo1;

/**
 * @Classname Client
 * @Created by 寂然
 * @Description 客户端
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {

        DeepProtoType deepProtoType = new DeepProtoType();

        deepProtoType.name = "小李";

        deepProtoType.deepCloneableTarget = new DeepCloneableTarget("名称","类型");

        DeepProtoType clone = (DeepProtoType) deepProtoType.clone();
        DeepProtoType clone1 = (DeepProtoType) deepProtoType.clone();
        DeepProtoType clone2 = (DeepProtoType) deepProtoType.clone();

        System.out.println(clone.deepCloneableTarget.hashCode());

        System.out.println(clone1.deepCloneableTarget.hashCode());

        System.out.println(clone2.deepCloneableTarget.hashCode());

    }
}
