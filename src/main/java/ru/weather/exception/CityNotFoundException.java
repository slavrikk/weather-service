package ru.weather.exception;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(String city) {
        super("City " + "'" + city + "' is not found!");
    }
}
