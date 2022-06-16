package com.example.demo4.controllers;

import java.util.Calendar;

public class Warehouse {
    String name;
    String firm;
    float price;
    int amount;
    int w;
    Calendar date;
    int minimum_batch;

    public Warehouse() {
    }

    public Warehouse(String name, String firm, float price, int amount, int w, Calendar date, int minimum_batch) {
        this.name = name;
        this.firm = firm;
        this.price = price;
        this.amount = amount;
        this.w = w;
        this.date = date;
        this.minimum_batch = minimum_batch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public int getMinimum_batch() {
        return minimum_batch;
    }

    public void setMinimum_batch(int minimum_batch) {
        this.minimum_batch = minimum_batch;
    }

}
