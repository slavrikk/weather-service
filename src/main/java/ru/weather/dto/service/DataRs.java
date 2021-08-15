package ru.weather.dto.service;

import lombok.Data;

import java.util.GregorianCalendar;
import java.util.List;

@Data
public class DataRs {

    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Sys sys;
    private String name;
    private String cod;
    private String message;

    @Data
    public static class Weather {
        private String main;
        private String description;
    }

    @Data
    public static class Sys {
        private String country;
        private GregorianCalendar sunrise;
        private GregorianCalendar sunset;

    }

    @Data
    public static class Main {
        private Double temp;
        private Double feels_like;
        private String pressure;
    }

    @Data
    public static class Wind {
        private String speed;
    }
}
