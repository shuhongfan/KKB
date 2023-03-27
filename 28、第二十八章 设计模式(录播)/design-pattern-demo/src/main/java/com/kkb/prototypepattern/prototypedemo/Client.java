package com.kkb.prototypepattern.prototypedemo;

/**
 * @Classname Client
 * @Created by 寂然
 * @Description 客户端  来使用原型类
 */
public class Client {

    public static void main(String[] args) {

        Resume resume = new Resume("李逵", "Java开发", "面议");

        for (int i = 0; i < 10; i++) {

            Resume clone = (Resume) resume.clone();

            System.out.println(clone);
        }
    }
}
