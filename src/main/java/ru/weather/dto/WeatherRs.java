package ru.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherRs {

    private String city;
    private String country;
    private String currentWeather;
    private Double temperature;
    private Double feelTemperature;
    private String pressure;
    private String windSpeed;
    private String sunrise;
    private String sunset;

}
