package com.kkb.prototypepattern.defaultdemo;

/**
 * @Classname Resume
 * @Created by 寂然
 * @Description 简历类
 */
public class Resume {

    private String name;


    private String job;  //期望职位

    private String salary; //期望薪资

    public String getName() {
        return name;
    }
    public Resume(String name, String job, String salary) {
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }



    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
