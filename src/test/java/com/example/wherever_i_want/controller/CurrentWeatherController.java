package com.example.wherever_i_want.controller;

import com.example.wherever_i_want.domain.dto.CurrentWeatherDto;
import com.example.wherever_i_want.domain.dto.MainDto;
import com.example.wherever_i_want.meteo.client.CurrentWeatherClient;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CurrentWeatherController.class)
public class CurrentWeatherController {

    private static final double TEMPERATURE_INDICATOR =  273.15;
    @Value("${weather.api.endpoint.prod}")
    private String weatherApiEndpoint;
    @Value("${weather.app.key}")
    private String weatherAppKey;

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CurrentWeatherClient currentWeatherClient;

    @Test
    public void getCurrentWeather() throws Exception {
        CurrentWeatherDto currentWeatherDto = new CurrentWeatherDto(new MainDto(15.0, 1007, 56));
        when(currentWeatherClient.getCurrentWeather("London")).thenReturn(currentWeatherDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(currentWeatherDto);

        mockMvc.perform(get("/currentWeather/getCurrentWeather/London")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void contextLoads() {
    }

}
