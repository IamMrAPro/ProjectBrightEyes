/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model;

/**
 *
 * @author anhha
 */
public class glasses {
    private String glassID;
    private String glassName;
    private String color;
    private String gender;
    private String material;
    private String style;

    public glasses() {
    }

    public glasses(String glassID, String glassName, String color, String gender, String material, String style) {
        this.glassID = glassID;
        this.glassName = glassName;
        this.color = color;
        this.gender = gender;
        this.material = material;
        this.style = style;
    }

    public String getGlassID() {
        return glassID;
    }

    public void setGlassID(String glassID) {
        this.glassID = glassID;
    }

    public String getGlassName() {
        return glassName;
    }

    public void setGlassName(String glassName) {
        this.glassName = glassName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    
}
