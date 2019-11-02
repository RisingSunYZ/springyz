package com.anotation.model.lifeStyle;

public class CarPrototype {

    private String bank;

    public CarPrototype(String bank) {
        this.bank = bank;
        System.out.println("Car costruct ....");
    }

    public void init(){
        System.out.println("car init..."+this.bank);
    }

    public void destory(){
        System.out.println("car destory....");
    }
}
