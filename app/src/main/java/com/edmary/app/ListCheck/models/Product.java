package com.edmary.app.ListCheck.models;

public class Product {

    private String name;
    private Boolean chek;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChek() {
        return chek;
    }

    public void setChek(Boolean chek) {
        this.chek = chek;
    }

    public Product(String nameP, Boolean chekP){
        this.chek=chekP;
        this.name=nameP;
    }

}
