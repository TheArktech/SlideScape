package com.thearktech.slidescape.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

/**
 * Created by tudor on 4/29/17.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Geolocation {
    private String type;
    private List<Integer> coordinates;
}
