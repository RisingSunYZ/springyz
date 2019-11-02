package com.xml.model;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2019/10/22 15:16
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Car {

    private Double speed;


    private String bank;

    private Double price;

    private void carInit(){
        System.out.println("car init...........");
    }

    private void carDestory(){
        System.out.println("car destory...........");
    }


    public Car() {
    }

    public Car(Double speed, String bank, Double price) {
        this.speed = speed;
        this.bank = bank;
        this.price = price;

        System.out.println("Cat constuct.................");
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", bank='" + bank + '\'' +
                ", price=" + price +
                '}';
    }
}
