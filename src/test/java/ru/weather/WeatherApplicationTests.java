package ru.weather;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import ru.weather.controller.WeatherController;
import ru.weather.dto.WeatherRs;
import ru.weather.dto.service.DataRs;
import ru.weather.util.DataProvider;

@SpringBootTest
public class WeatherApplicationTests {

    @Autowired
    private WeatherController weatherController;

    @MockBean
    private RestTemplate restTemplate;

    private DataRs mockRs;

    @BeforeEach
    public void mock() {
        mockRs = DataProvider.getObjectFromJson("service_response", DataRs.class);
        Mockito.when(restTemplate.getForObject(Mockito.anyString(),
                Mockito.anyObject()))
                .thenReturn(mockRs);
    }

    @Test
    void weatherByNameControllerTest() {
        WeatherRs response = weatherController.weatherByName("Saint Petersburg");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getCity(), mockRs.getName());
        Assertions.assertEquals(response.getTemperature(), Math.floor(mockRs.getMain().getTemp()));
    }

}
