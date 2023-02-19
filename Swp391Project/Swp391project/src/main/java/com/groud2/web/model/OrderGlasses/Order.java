/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model.OrderGlasses;

import com.groud2.web.model.glasses;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author anhha
 */
public class Order {
    private int OrderId;
    private String Glasses;
   
    private Cart cart;
    private String CustomerId, ShipAddress, ShipCity, unitShip;
    private float shiping;
    private float tax;
    private String OderDate, ShippedDate;
    private String Status;

    public Order() {
    }

    public Order( Cart cart, String CustomerId, String ShipAddress, String ShipCity, String unitShip, float shiping, float tax, String OderDate, String ShippedDate, String Status) {
        
        this.cart = cart;
        this.CustomerId = CustomerId;
        this.ShipAddress = ShipAddress;
        this.ShipCity = ShipCity;
        this.unitShip = unitShip;
        this.shiping = shiping;
        this.tax = tax;
        this.OderDate = OderDate;
        this.ShippedDate = ShippedDate;
        this.Status = Status;
    }

    public Order(int OrderId, String Glasses, String CustomerId, String ShipAddress, String unitShip, float shiping, String OderDate, String Status) {
        this.OrderId = OrderId;
        this.Glasses = Glasses;
        this.CustomerId = CustomerId;
        this.ShipAddress = ShipAddress;
        this.unitShip = unitShip;
        this.shiping = shiping;
        this.OderDate = OderDate;
        this.Status = Status;
    }
    
    public String getShiping() {
        return  String.format("%.2f",shiping);
    }

    public void setShiping(float shiping) {
        this.shiping = shiping;
    }

    public String getTax() {
        return String.format("%.2f",tax);
    }

    public void setTax(float tax) {
        this.tax = tax;
    }
    public String getSubtotal(){
        return String.format("%.2f", cart.getTotalMoney());
    }
    public String getTotal(){
        return String.format("%.2f", cart.getTotalMoney()+tax+shiping);
    }

    

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getShipAddress() {
        return ShipAddress;
    }

    public void setShipAddress(String ShipAddress) {
        this.ShipAddress = ShipAddress;
    }

    public String getShipCity() {
        return ShipCity;
    }

    public void setShipCity(String ShipCity) {
        this.ShipCity = ShipCity;
    }

    public String getUnitShip() {
        return unitShip;
    }

    public void setUnitShip(String unitShip) {
        this.unitShip = unitShip;
    }

    public String getOderDate() {
        return OderDate;
    }

    public void setOderDate(String OderDate) {
        this.OderDate = OderDate;
    }

 

    public String getShippedDate() {
        return ShippedDate;
    }

    public void setShippedDate(String ShippedDate) {
        this.ShippedDate = ShippedDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

   
    
}
