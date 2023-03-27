package com.kkb.designpatternprinciple.demeterprinciple;

//总部管理类

import java.util.ArrayList;
import java.util.List;

public class SchoolManager {

    //获取总部员工的方法
    public List<SchoolEmployee> getSchoolEmployee(){

        ArrayList<SchoolEmployee> schoolEmployees = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            SchoolEmployee schoolEmployee = new SchoolEmployee();
            schoolEmployee.setId("总部员工 ，id是" + i);

            schoolEmployees.add(schoolEmployee);
        }

        return schoolEmployees;
    }

    //打印方法
    public void printAllEmployee(CollegeManager collegeManager){

        //打印总部的学院员工
        List<SchoolEmployee> schoolEmployee = this.getSchoolEmployee();
        for (SchoolEmployee employee : schoolEmployee) {
            System.out.println(employee.getId());
        }
        System.out.println("------------------");
        //打印学院员工的操作
        collegeManager.printCollegeEmployee();

    }
}
