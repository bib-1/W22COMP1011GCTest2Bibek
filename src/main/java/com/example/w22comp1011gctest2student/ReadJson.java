package com.example.w22comp1011gctest2student;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public static Business getCustomerFromJson(String fileName)
    {
        Gson gson = new Gson();
        Business customers = null;

        //try with resources will autoclose any of the items in the ()
        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
        ) {
            customers =  gson.fromJson(jsonReader, Business.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static void main(String[] args) {
        Business c = getCustomerFromJson("customers.json");
        System.out.println(c.getCustomers().get(0).totalPurchase());
        System.out.println(c.getCustomers().get(0).getFirstName());


    }
}
