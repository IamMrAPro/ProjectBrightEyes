/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model.OrderGlasses;

import java.sql.Date;

/**
 *
 * @author anhha
 */
public class Order {
    private int OrderId;
    private String CustomerId, ShipAddress, ShipCity, unitShip;
    private Date OderDate, RequiredDate, ShippedDate;
    private String Status;

    public Order() {
    }

    public Order(int OrderId, String CustomerId, String ShipAddress, String ShipCity, String unitShip, Date OderDate, Date RequiredDate, Date ShippedDate, String Status) {
        this.OrderId = OrderId;
        this.CustomerId = CustomerId;
        this.ShipAddress = ShipAddress;
        this.ShipCity = ShipCity;
        this.unitShip = unitShip;
        this.OderDate = OderDate;
        this.RequiredDate = RequiredDate;
        this.ShippedDate = ShippedDate;
        this.Status = Status;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
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

    public Date getOderDate() {
        return OderDate;
    }

    public void setOderDate(Date OderDate) {
        this.OderDate = OderDate;
    }

    public Date getRequiredDate() {
        return RequiredDate;
    }

    public void setRequiredDate(Date RequiredDate) {
        this.RequiredDate = RequiredDate;
    }

    public Date getShippedDate() {
        return ShippedDate;
    }

    public void setShippedDate(Date ShippedDate) {
        this.ShippedDate = ShippedDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
}
