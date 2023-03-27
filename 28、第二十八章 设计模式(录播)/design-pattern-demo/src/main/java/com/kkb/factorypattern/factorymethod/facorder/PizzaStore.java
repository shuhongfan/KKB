package com.kkb.factorypattern.factorymethod.facorder;

import java.util.Scanner;

/**
 * @Classname PizzaStore
 * @Created by 寂然
 * @Description 客户端
 */
public class PizzaStore {

    public static void main(String[] args) {

        System.out.println("请问您希望在哪个城市订购披萨");

        Scanner scanner = new Scanner(System.in);

        String address = scanner.next();

        if (address.equals("北京")){

            new BJOrderFactory();
        } else if (address.equals("上海")){

            new SHOrderFactory();
        } else {

            System.out.println("抱歉，您目前所在的城市没有开通披萨订购功能");
        }
    }
}
