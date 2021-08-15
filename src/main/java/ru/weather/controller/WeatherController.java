package ru.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.weather.dto.CoordinateRq;
import ru.weather.dto.WeatherRs;
import ru.weather.service.WeatherGettingService;

import java.util.List;

@RestController()
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherGettingService service;

    @GetMapping()
    public WeatherRs weatherByName(@RequestParam(value = "city") String name) {
        return service.getWeatherByCityName(name);
    }

    @PostMapping("/cities")
    public List<WeatherRs> weatherCitiesByCoordinate(@RequestBody CoordinateRq rq) {
        return service.getCitiesWeatherByCoordinate(rq);
    }
}
