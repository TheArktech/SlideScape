package com.thearktech.slidescape.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;

/**
 * Created by tudor on 4/29/17.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Event {
    private String continentCode;
    private String countryCode;
    private String countryName;
    private Date date;
    private Geolocation geolocation;
    private String hazardType;
    private String injuries;
    private String landslideSize;
    private String landslideType;
    private long latitude;
    private long longitude;
    private String near;
    private String nearestPlaces;
    private int population;
    private String stormName;
    private String trigger;

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    public String getHazardType() {
        return hazardType;
    }

    public void setHazardType(String hazardType) {
        this.hazardType = hazardType;
    }

    public String getInjuries() {
        return injuries;
    }

    public void setInjuries(String injuries) {
        this.injuries = injuries;
    }

    public String getLandslideSize() {
        return landslideSize;
    }

    public void setLandslideSize(String landslideSize) {
        this.landslideSize = landslideSize;
    }

    public String getLandslideType() {
        return landslideType;
    }

    public void setLandslideType(String landslideType) {
        this.landslideType = landslideType;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public String getNear() {
        return near;
    }

    public void setNear(String near) {
        this.near = near;
    }

    public String getNearestPlaces() {
        return nearestPlaces;
    }

    public void setNearestPlaces(String nearestPlaces) {
        this.nearestPlaces = nearestPlaces;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getStormName() {
        return stormName;
    }

    public void setStormName(String stormName) {
        this.stormName = stormName;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }
}
