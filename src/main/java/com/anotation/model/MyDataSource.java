package com.anotation.model;

public class MyDataSource {

    private String name;
    private String paswd;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaswd() {
        return paswd;
    }

    public void setPaswd(String paswd) {
        this.paswd = paswd;
    }

    @Override
    public String toString() {
        return "MyDataSource{" +
                "name='" + name + '\'' +
                ", paswd='" + paswd + '\'' +
                '}';
    }
}
