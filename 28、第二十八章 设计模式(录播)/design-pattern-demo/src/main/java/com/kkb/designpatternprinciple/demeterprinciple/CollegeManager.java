package com.kkb.designpatternprinciple.demeterprinciple;


import java.util.ArrayList;
import java.util.List;

//学院的管理类
//提供一个获取学院员工的方法
public class CollegeManager {

    public List<CollegeEmployee> getCollegeEmployee(){

        ArrayList<CollegeEmployee> collegeEmployees = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            CollegeEmployee collegeEmployee = new CollegeEmployee();
            collegeEmployee.setId("学院员工，id是" + i);
            collegeEmployees.add(collegeEmployee);
        }

        return collegeEmployees;
    }

    //打印学院员工的方法
    public void printCollegeEmployee(){

        List<CollegeEmployee> collegeEmployee = getCollegeEmployee();
        for (CollegeEmployee employee : collegeEmployee) {
            System.out.println(employee.getId());
        }

    }


}
