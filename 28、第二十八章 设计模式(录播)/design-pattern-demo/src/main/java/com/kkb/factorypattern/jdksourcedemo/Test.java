package com.kkb.factorypattern.jdksourcedemo;

import java.util.Calendar;

/**
 * @Classname Test
 * @Created by 寂然
 * @Description I walk very slowly, but I never walk backwards
 */
public class Test {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        System.out.println(calendar.get(Calendar.DATE));
    }
}
