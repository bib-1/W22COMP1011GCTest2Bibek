package com.example.w22comp1011gctest2student;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Business {
    @SerializedName("Customers")
    private ArrayList<Customer> customers;

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
