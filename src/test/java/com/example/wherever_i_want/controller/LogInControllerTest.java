package com.example.wherever_i_want.controller;

import com.example.wherever_i_want.domain.dto.LogInDto;
import com.example.wherever_i_want.domain.dto.RegisterDto;
import com.example.wherever_i_want.domain.loginRegisterStaff.LogIn;
import com.example.wherever_i_want.domain.loginRegisterStaff.Register;
import com.example.wherever_i_want.domain.loginRegisterStaff.User;
import com.example.wherever_i_want.mapper.LogInMapper;
import com.example.wherever_i_want.service.LogInService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LogInController.class)
public class LogInControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LogInMapper mapper;
    @MockBean
    private LogInService service;

    @Test
    public void shouldDeleteLog() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/whereverIWant/logIn/deleteLogInById/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCreateLog() throws Exception {

        User user = new User();
        user.setId(1);
        LogIn log = new LogIn(1, user, "logindate", "logintime");
        LogInDto logDto = new LogInDto(1, user.getId(), "logindate", "logintime");

        when(mapper.mapToLogInDto(any(LogIn.class))).thenReturn(logDto);
        when(mapper.mapToLogInDto(any())).thenReturn(logDto);
        when(service.save(log)).thenReturn(log);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(log);

        mockMvc.perform(post("/whereverIWant/logIn/createLogIn")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.userId", is(1)))
                .andExpect(jsonPath("$.loginDate", is("logindate")))
                .andExpect(jsonPath("$.loginTime", is("logintime")));
    }

    @Test
    public void shouldGetLogIn() throws Exception {
        User user = new User();
        user.setId(1);
        LogIn log = new LogIn(1, user, "logindate", "logintime");
        LogInDto logDto = new LogInDto(1, user.getId(), "logindate", "logintime");

        List<LogIn> list = new ArrayList<>();
        List<LogInDto> dtos = new ArrayList<>();
        list.add(log);
        dtos.add(logDto);

        when(service.findById(log.getId())).thenReturn(log);
        when(mapper.mapToLogInDto(any(LogIn.class))).thenReturn(logDto);
        when(service.getAll()).thenReturn(list);
        when(mapper.mapToLogInDtoList(anyList())).thenReturn(dtos);

        mockMvc.perform(get("/whereverIWant/logIn/getLogInById/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllLogins() throws Exception {

        LogInDto logDto1 = new LogInDto(1, 1, "logindate", "logintime");
        LogInDto logDto2 = new LogInDto(1, 1, "logindate", "logintime");
        List<LogInDto> list = new ArrayList<>();
        list.add(logDto1);
        list.add(logDto2);

        when(mapper.mapToLogInDtoList(anyList())).thenReturn(list);

        mockMvc.perform(get("/whereverIWant/logIn/getAllLogsIn")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void shouldFetchEmptyLoginList() throws Exception {
        List<LogIn> list = new ArrayList<>();
        List<LogInDto> dtoList = new ArrayList<>();

        when(service.getAll()).thenReturn(list);
        when(mapper.mapToLogInDtoList(anyList())).thenReturn(dtoList);
        mockMvc.perform(get("/whereverIWant/logIn/getAllLogsIn").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void contextLoads() {
    }
}
