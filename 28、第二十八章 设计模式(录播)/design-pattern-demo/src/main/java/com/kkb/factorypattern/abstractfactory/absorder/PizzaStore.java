package com.kkb.factorypattern.abstractfactory.absorder;

import java.util.Scanner;

//客户端
public class PizzaStore {

    public static void main(String[] args) {

        System.out.println("请输入要订购披萨的地点");

        String address = new Scanner(System.in).next();

        if (address.equals("北京")){

            new OrderPizza(new BJFactory());

        }else if (address.equals("上海")){

            new OrderPizza(new SHFactory());

        }else{

            System.out.println("该地点暂未开通订购披萨功能");

        }
    }
}
