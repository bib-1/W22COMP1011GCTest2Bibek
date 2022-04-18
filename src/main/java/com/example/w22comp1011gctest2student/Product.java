package com.example.w22comp1011gctest2student;

public class Product {
  private String sku;
  private String name;
  private double salePrice;
  private double regularPrice;
  private String image;

  public String getSku() {
    return sku;
  }

  public String getName() {
    return name;
  }

  public double getSalePrice() {
    return salePrice;
  }

  public double getRegularPrice() {
    return regularPrice;
  }

  public String getImage() {
    return image;
  }

  @Override
  public String toString() {
    return String.format("%s-$%.2f",name, salePrice);
  }
}
