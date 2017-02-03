package com.example.a47276138y.bicingapp;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by 47276138y on 31/01/17.
 */

public class Station {

    private int id;
    private String type;
    private double latitude;
    private double longitude;
    private String streetName;
    private int streetNumber;
    private double altitude;
    private int slots;
    private int bike;
    private ArrayList<Integer> nearbyStations;
    private String status;

    public Station(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public int getBike() {
        return bike;
    }

    public void setBike(int bike) {
        this.bike = bike;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public ArrayList<Integer> getNearbyStations() {
        return nearbyStations;
    }

    public void setNearbyStations(ArrayList<Integer> nearbyStations) {
        this.nearbyStations = nearbyStations;
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
