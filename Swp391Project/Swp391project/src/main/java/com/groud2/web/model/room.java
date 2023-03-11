/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.model;

/**
 *
 * @author Ao
 */
public class room {
    String roomID, roomName, roomFunction;

    public room() {
    }

    public room(String roomID, String roomName, String roomFunction) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomFunction = roomFunction;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomFunction() {
        return roomFunction;
    }

    public void setRoomFunction(String roomFunction) {
        this.roomFunction = roomFunction;
    }
    
    
}
