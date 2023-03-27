package com.kkb.designpatternprinciple.dependenceinversionprinciple;

//案例演示 - 依赖关系的传递演示
public class ThreeWaysDemo {
    public static void main(String[] args) {

    }
}

//通过接口传递
//假设消息规范

/*
interface IMessage{

    void sendMessage(Produce produce);
}

//消息真正的生产者
interface Produce{

    void produceMessage();
}

class Worker implements IMessage{

    @Override
    public void sendMessage(Produce produce) {
        produce.produceMessage();
    }
}*/


//通过构造器来传递
/*
interface IMessage{

    void sendMessage();
}

//消息真正的生产者
interface Produce{

    void produceMessage();
}

class Worker implements IMessage{

    public Produce produce;

    public Worker(Produce produce){

        this.produce = produce;
    }

    @Override
    public void sendMessage() {
        this.produce.produceMessage();
    }
}*/


//通过set()方法
interface IMessage{

    void sendMessage();
}

//消息真正的生产者
interface Produce{

    void produceMessage();
}

class Worker implements IMessage{

    public Produce produce;

    public void setProduce(Produce produce){
        this.produce = produce;
    }


    @Override
    public void sendMessage() {
        this.produce.produceMessage();
    }
}