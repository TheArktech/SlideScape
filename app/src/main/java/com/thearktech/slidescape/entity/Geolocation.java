package com.thearktech.slidescape.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.IOException;
import java.util.List;

/**
 * Created by tudor on 4/29/17.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Geolocation {
    private String type;
    private List<Float> coordinates;

    public Geolocation() {

    }

    public Geolocation(String json) {
        try {
            Geolocation geolocation = new ObjectMapper().readValue(json, Geolocation.class);
            type = geolocation.getType();
            coordinates = geolocation.getCoordinates();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Float> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Float> coordinates) {
        this.coordinates = coordinates;
    }
}
