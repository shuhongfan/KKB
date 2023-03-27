package com.kkb.prototypepattern.deepclonedemo2;

//方式一升级：测试级联克隆
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {

        DeepProtoType deepProtoType = new DeepProtoType();

        deepProtoType.name = "小李";

        deepProtoType.deepCloneableTarget = new DeepCloneableTarget("老李","克隆类");

        deepProtoType.deepCloneableTarget.witness = new Witness("证明人", "职务");

        DeepProtoType clone = (DeepProtoType) deepProtoType.clone();

        DeepProtoType clone1 = (DeepProtoType) deepProtoType.clone();

        System.out.println(clone);

        System.out.println(clone1);

        System.out.println(clone.deepCloneableTarget.witness.hashCode());

        System.out.println(clone1.deepCloneableTarget.witness.hashCode());


    }
}
