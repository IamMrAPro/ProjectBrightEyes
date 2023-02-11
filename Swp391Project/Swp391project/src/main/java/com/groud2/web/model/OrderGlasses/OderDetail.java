/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model.OrderGlasses;

/**
 *
 * @author anhha
 */
public class OderDetail {
    private int id,quantity; 
    private String glassesId;
    private double  price;

    public OderDetail() {
    }

    public OderDetail(int id, int quantity, String glassesId, double price) {
        this.id = id;
        this.quantity = quantity;
        this.glassesId = glassesId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getGlassesId() {
        return glassesId;
    }

    public void setGlassesId(String glassesId) {
        this.glassesId = glassesId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
