/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model;

/**
 *
 * @author Ao
 */
public class Attendance {
    String id, attendanceDate, userId, fullname, checkin1, checkout1, checkin2, checkout2, checkin3, checkout3, checkin4, checkout4;

    public Attendance(String id, String attendanceDate, String userId, String fullname, String checkin1, String checkout1, String checkin2, String checkout2, String checkin3, String checkout3, String checkin4, String checkout4) {
        this.id = id;
        this.attendanceDate = attendanceDate;
        this.userId = userId;
        this.fullname = fullname;
        this.checkin1 = checkin1;
        this.checkout1 = checkout1;
        this.checkin2 = checkin2;
        this.checkout2 = checkout2;
        this.checkin3 = checkin3;
        this.checkout3 = checkout3;
        this.checkin4 = checkin4;
        this.checkout4 = checkout4;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCheckin1() {
        return checkin1;
    }

    public void setCheckin1(String checkin1) {
        this.checkin1 = checkin1;
    }

    public String getCheckout1() {
        return checkout1;
    }

    public void setCheckout1(String checkout1) {
        this.checkout1 = checkout1;
    }

    public String getCheckin2() {
        return checkin2;
    }

    public void setCheckin2(String checkin2) {
        this.checkin2 = checkin2;
    }

    public String getCheckout2() {
        return checkout2;
    }

    public void setCheckout2(String checkout2) {
        this.checkout2 = checkout2;
    }

    public String getCheckin3() {
        return checkin3;
    }

    public void setCheckin3(String checkin3) {
        this.checkin3 = checkin3;
    }

    public String getCheckout3() {
        return checkout3;
    }

    public void setCheckout3(String checkout3) {
        this.checkout3 = checkout3;
    }

    public String getCheckin4() {
        return checkin4;
    }

    public void setCheckin4(String checkin4) {
        this.checkin4 = checkin4;
    }

    public String getCheckout4() {
        return checkout4;
    }

    public void setCheckout4(String checkout4) {
        this.checkout4 = checkout4;
    }
    
    
}
