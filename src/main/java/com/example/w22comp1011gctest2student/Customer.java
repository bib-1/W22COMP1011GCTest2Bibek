package com.example.w22comp1011gctest2student;

import com.google.gson.annotations.SerializedName;
import javafx.fxml.FXML;

import java.util.ArrayList;

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private ArrayList<Product> purchases;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Product> getPurchases() {
        return purchases;
    }

    public double totalPurchase(){
        double salesPrice = 0;
        for (Product c: getPurchases()){
            salesPrice +=  c.getSalePrice();
        }
        salesPrice = getPurchases().stream().mapToDouble(e -> e.getSalePrice()).sum();
        return  salesPrice;
    };
}
