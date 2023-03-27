package com.kkb.prototypepattern.deepclonedemo3;

/**
 * @Classname Client
 * @Created by 寂然
 * @Description 客户端
 */
public class Client {

    public static void main(String[] args) {

        DeepProtoType deepProtoType = new DeepProtoType();

        deepProtoType.name = "小李";

        deepProtoType.deepCloneableTarget = new DeepCloneableTarget("名称","类型");

        DeepProtoType deepProtoType1 = (DeepProtoType) deepProtoType.deepClone();
        DeepProtoType deepProtoType2 = (DeepProtoType) deepProtoType.deepClone();

        System.out.println(deepProtoType1.toString());
        System.out.println(deepProtoType2.toString());

        System.out.println(deepProtoType1.deepCloneableTarget.hashCode());
        System.out.println(deepProtoType2.deepCloneableTarget.hashCode()); //测试

    }
}
