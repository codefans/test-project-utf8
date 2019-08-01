package com.codefans.opensource.spring.bean;

/**
 * @author: codefans
 * @date: 2019-08-01 10:45
 */
public class Car {

    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "name=" + name;
    }



}
