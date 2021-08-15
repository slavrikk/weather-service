package ru.weather.util;

import ru.weather.dto.WeatherRs;
import ru.weather.dto.service.DataListRs;
import ru.weather.dto.service.DataRs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherMapper {

    public static WeatherRs mapDataToRs(DataRs data) {
        WeatherRs response = new WeatherRs();
        response.setCity(data.getName());
        response.setCountry(data.getSys().getCountry());
        if (!data.getWeather().isEmpty()) {
            response.setCurrentWeather(data.getWeather().get(0).getDescription());
        }
        response.setTemperature(Math.floor(data.getMain().getTemp()));
        response.setFeelTemperature(Math.floor(data.getMain().getFeels_like()));
        response.setPressure(data.getMain().getPressure());
        response.setWindSpeed(data.getWind().getSpeed());
        DateFormat df = new SimpleDateFormat("hh:mm:ss");
        if (data.getSys().getSunrise() != null & data.getSys().getSunset() != null) {
            response.setSunrise(df.format(data.getSys().getSunrise().getTime()));
            response.setSunset(df.format(data.getSys().getSunset().getTime()));
        }
        return response;
    }

    public static List<WeatherRs> mapDataListToWeatherRs(DataListRs listRs) {

        return listRs.getList()
                .stream()
                .map(WeatherMapper::mapDataToRs)
                .collect(Collectors.toList());
    }
}
