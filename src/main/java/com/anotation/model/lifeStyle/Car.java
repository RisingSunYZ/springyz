package com.anotation.model.lifeStyle;

import org.springframework.beans.factory.annotation.Value;

public class Car {

    @Value("${bankName}")
    private String bank;

    public Car(String bank) {
        this.bank = bank;
        System.out.println("Car costruct ....");
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "bank='" + bank + '\'' +
                '}';
    }

    public void init(){
        System.out.println("car init..."+this.bank);
    }

    public void destory(){
        System.out.println("car destory....");
    }
}
