package com.kkb.prototypepattern.shallowcopy;

//简历类2.0
public class Resume implements Cloneable{

    private String name;

    private String job;

    private String salary;

    private Witness witness; //证明人

    public Resume(String name, String position, String salary) {
        this.name = name;
        this.job = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return job;
    }

    public void setPosition(String position) {
        this.job = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Witness getWitness() {
        return witness;
    }

    public void setWitness(Witness witness) {
        this.witness = witness;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    @Override
    protected Object clone() {

        Resume resume = null;

        try{
            resume = (Resume) super.clone();

        }catch (CloneNotSupportedException e){

            e.printStackTrace();
        }
        return resume;
    }
}
