package com.kkb.designpatternprinciple.demeterprinciple;


//案例演示 - 迪米特法则

//客户端的角色
public class DemeterDemo {

    public static void main(String[] args) {

        new SchoolManager().printAllEmployee(new CollegeManager());

    }
}
//需求：有一个学校，下属有各个学院和总部，现要求打印出总部员工的ID和学院员工的ID