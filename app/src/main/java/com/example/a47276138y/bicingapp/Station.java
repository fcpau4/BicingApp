package com.example.a47276138y.bicingapp;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by 47276138y on 31/01/17.
 */

public class Station {


    private String id;
    private String type;
    private String latitude;
    private String longitude;
    private String streetName;
    private String streetNumber;
    private String altitude;
    private String slots;
    private String bike;
    private String status;

    public Station(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getSlots() {
        return slots;
    }

    public void setSlots(String slots) {
        this.slots = slots;
    }

    public String getBike() {
        return bike;
    }

    public void setBike(String bike) {
        this.bike = bike;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Id: " + getId() + "Type: " + getType() + "Latitude: " + getLatitude() + "Longitude: " + getLongitude() + "Street Number: " +
                getStreetNumber() + "Street Name: " + getStreetName() + "Latitude: " + getLatitude() + "Bike: " + getBike() + "Slots: " + getSlots() + "Status: " + getStatus();
    }
}
