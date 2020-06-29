package com.example.wherever_i_want.controller;

import com.example.wherever_i_want.domain.Request;
import com.example.wherever_i_want.domain.dto.RegisterDto;
import com.example.wherever_i_want.domain.dto.RequestDto;
import com.example.wherever_i_want.domain.loginRegisterStaff.Register;
import com.example.wherever_i_want.domain.loginRegisterStaff.User;
import com.example.wherever_i_want.mapper.RegisterMapper;
import com.example.wherever_i_want.service.RegisterService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RegisterController.class)
public class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RegisterMapper mapper;
    @MockBean
    private RegisterService service;

    @Test
    public void shouldDeleteRegister() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/whereverIWant/register/deleteRegisterById/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCreateRegister() throws Exception {

        Register register = new Register();
        register.setId(1);
        RegisterDto registerDto = new RegisterDto(1, 1, "registerdate", "registertime");

        when(mapper.mapToRegisterDto(any(Register.class))).thenReturn(registerDto);
        when(mapper.mapToRegisterDto(any())).thenReturn(registerDto);
        when(service.save(register)).thenReturn(register);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(register);

        mockMvc.perform(post("/whereverIWant/register/createRegister?nick=nick&firstname=name&lastname=name&age=12&eMail=mail&password=password")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.registerDate", is("registerdate")))
                .andExpect(jsonPath("$.registerTime", is("registertime")));
    }

    @Test
    public void shouldGetRegister() throws Exception {
        User user = new User();
        user.setId(1);
        Register register = new Register(1, user, "registerdate", "registertime");
        RegisterDto registerDto = new RegisterDto(1, user.getId(), "registerdate", "registertime");

        List<Register> list = new ArrayList<>();
        List<RegisterDto> dtos = new ArrayList<>();
        list.add(register);
        dtos.add(registerDto);

        when(service.findById(register.getId())).thenReturn(register);
        when(mapper.mapToRegisterDto(any(Register.class))).thenReturn(registerDto);
        when(service.getAll()).thenReturn(list);
        when(mapper.mapToRegisterDtoList(anyList())).thenReturn(dtos);

        mockMvc.perform(get("/whereverIWant/register/getRegister/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllRegisters() throws Exception {

        RegisterDto registerDto1 = new RegisterDto(1, 1, "registerdate", "registertime");
        RegisterDto registerDto2 = new RegisterDto(2, 2, "registerdate", "registertime");
        List<RegisterDto> list = new ArrayList<>();
        list.add(registerDto1);
        list.add(registerDto2);

        when(mapper.mapToRegisterDtoList(anyList())).thenReturn(list);

        mockMvc.perform(get("/whereverIWant/register/getAllRegisters")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void shouldFetchEmptyRegistersList() throws Exception {
        List<Register> list = new ArrayList<>();
        List<RegisterDto> dtoList = new ArrayList<>();

        when(service.getAll()).thenReturn(list);
        when(mapper.mapToRegisterDtoList(anyList())).thenReturn(dtoList);
        mockMvc.perform(get("/whereverIWant/register/getAllRegisters").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void contextLoads() {
    }
}
