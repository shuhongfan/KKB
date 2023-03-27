package com.kkb.prototypepattern.defaultdemo;

/**
 * @Classname Client
 * @Created by 寂然
 * @Description 客户端  打印很多份简历  简历信息是一样的
 */
public class Client {

    public static void main(String[] args) {

        Resume resume = new Resume("李逵", "Java开发", "面议");

        for (int i = 0; i < 10; i++) {

            Resume clone = new Resume(resume.getName(), resume.getJob(), resume.getSalary());

            System.out.println(clone + "已打印成功");

        }


        new Object();
    }
}
