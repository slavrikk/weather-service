package ru.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ru.weather.dto.CoordinateRq;
import ru.weather.dto.WeatherRs;
import ru.weather.dto.service.DataListRs;
import ru.weather.dto.service.DataRs;
import ru.weather.exception.CityNotFoundException;
import ru.weather.exception.CoordinateException;
import ru.weather.util.Decoder;

import java.util.List;

import static ru.weather.util.WeatherMapper.mapDataListToWeatherRs;
import static ru.weather.util.WeatherMapper.mapDataToRs;

@Service
public class WeatherGettingService {

    private static final String WEATHER_SERVICE = "weather";
    private static final String FIND_SERVICE = "find";

    @Value("${url.service}")
    private String url;

    @Value("${unit}")
    private String unit;

    @Value("${lang}")
    private String lang;

    @Value("${api.key}")
    private String key;

    @Value("${default.city.amount}")
    private Integer cityAmount;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherRs getWeatherByCityName(String city) {
        DataRs dataRs = null;
        try {
            dataRs = restTemplate.getForObject(composeCommonUrl(WEATHER_SERVICE) + "q=" + city, DataRs.class);
        } catch (HttpClientErrorException ex) {
            throw new CityNotFoundException(city);
        }

        return mapDataToRs(dataRs);
    }

    public List<WeatherRs> getCitiesWeatherByCoordinate(CoordinateRq rq) {
        DataListRs dataListRs = null;
        try {
            dataListRs = restTemplate.getForObject(composeCommonUrl(FIND_SERVICE) +
                    composeCoordinateUrl(rq), DataListRs.class);
        } catch (HttpClientErrorException ex) {
            throw new CoordinateException(ex.getMessage());
        }
        return mapDataListToWeatherRs(dataListRs);
    }

    private String composeCommonUrl(String serviceName) {
        return String.format(url + serviceName + "?units=%s&lang=%s&appid=%s&"
                , unit, lang, Decoder.decodeKey(key));
    }

    private String composeCoordinateUrl(CoordinateRq rq) {
        return String.format("lat=%s&lon=%s&cnt=%s",
                rq.getLatitude(),
                rq.getLongitude(),
                rq.getCityAmount() != 0 ? rq.getCityAmount() : cityAmount);
    }

}
