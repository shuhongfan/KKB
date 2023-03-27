package com.kkb.prototypepattern.deepclonedemo2;

import java.io.Serializable;

//证明人类
public class Witness implements Serializable,Cloneable {

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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
