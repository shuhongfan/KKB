package com.kkb.prototypepattern.shallowcopy;

//证明人类
public class Witness {

    private String name;

    private String job; //职务

    public Witness(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "Witness{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
