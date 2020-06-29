package com.example.wherever_i_want.controller;

import com.example.wherever_i_want.domain.StationTemperatures;
import com.example.wherever_i_want.domain.dto.DataDto;
import com.example.wherever_i_want.domain.dto.MainDto;
import com.example.wherever_i_want.domain.dto.MeteostatStationTemperaturesDto;
import com.example.wherever_i_want.domain.dto.TemperatureDto;
import com.example.wherever_i_want.domain.loginRegisterStaff.LogIn;
import com.example.wherever_i_want.mapper.StationTemperaturesMapper;
import com.example.wherever_i_want.meteo.client.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MeteostatController.class)
public class MeteostatControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private Client client;
    @MockBean
    private StationTemperaturesMapper mapper;

    @Test
    public void getMeteostatStationTemperature() throws Exception {
        MeteostatStationTemperaturesDto mstDto = new MeteostatStationTemperaturesDto(
                                                    new DataDto(
                                                            new TemperatureDto(
                                                                    "-5.7",
                                                                    "-6.1",
                                                                    "-6.1",
                                                                    "-3.9",
                                                                    "-0.7",
                                                                    "1.8",
                                                                    "4.2",
                                                                    "5.0",
                                                                    "2.9",
                                                                    "0.1",
                                                                    "-3.2",
                                                                    "-5.2")));

        StationTemperatures temperatures = new StationTemperatures();
                            temperatures.setId(1);
                            temperatures.setCityId("01001");
                            temperatures.setJANUARY("-5.7");
                            temperatures.setFEBRUARY("-6.1");
                            temperatures.setMARCH("-6.1");
                            temperatures.setAPRIL("-3.9");
                            temperatures.setMAY("-0.7");
                            temperatures.setJUNE("1.8");
                            temperatures.setJULY("4.2");
                            temperatures.setAUGUST("5.0");
                            temperatures.setSEPTEMBER("2.9");
                            temperatures.setOCTOBER("0.1");
                            temperatures.setNOVEMBER("-3.2");
                            temperatures.setDECEMBER("-5.2");

        when(client.getMeteostatTemperaturesDto()).thenReturn(mstDto);
        when(mapper.mapMeteostatStationTemperaturesDtoToStationTemperatures("01001", mstDto)).thenReturn(temperatures);

        mockMvc.perform(get("/meteostat/getStationTemperatures").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



    @Test
    public void contextLoads() {
    }
}
