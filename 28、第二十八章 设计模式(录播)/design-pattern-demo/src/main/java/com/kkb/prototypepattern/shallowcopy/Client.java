package com.kkb.prototypepattern.shallowcopy;

/**
 * @Classname Client
 * @Created by 寂然
 * @Description 客户端
 */
public class Client {

    public static void main(String[] args) {

        Resume resume = new Resume("小李", "java开发", "面议");

        resume.setWitness(new Witness("三叔","养猪场CTO"));

        Resume clone = (Resume) resume.clone();
        Resume clone1 = (Resume) resume.clone();
        Resume clone2 = (Resume) resume.clone();

        System.out.println(clone.getWitness().hashCode());

        System.out.println(clone1.getWitness().hashCode());

        System.out.println(clone2.getWitness().hashCode());
    }
}
