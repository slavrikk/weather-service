package ru.weather.exception;

public class CityNotTransferException extends RuntimeException {

    public CityNotTransferException() {
        super("City is not transferred! Please put city in request like '?city={city}'");
    }
}
