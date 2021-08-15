package ru.weather.dto;

import lombok.Data;

@Data
public class CoordinateRq {

    private double latitude;
    private double longitude;
    private int cityAmount;
}
