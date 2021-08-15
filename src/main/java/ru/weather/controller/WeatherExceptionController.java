package ru.weather.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.weather.exception.CityNotFoundException;
import ru.weather.exception.CityNotTransferException;
import ru.weather.exception.CoordinateException;

@ControllerAdvice
public class WeatherExceptionController {

    @ResponseBody
    @ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String cityNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(CoordinateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String coordinateExceptionHandler(Exception ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String cityNotTransferHandler(Exception ex) {
        return new CityNotTransferException().getMessage();
    }


}
