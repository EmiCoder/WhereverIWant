package com.example.wherever_i_want.controller;

import com.example.wherever_i_want.domain.Request;
import com.example.wherever_i_want.domain.dto.RequestDto;
import com.example.wherever_i_want.domain.loginRegisterStaff.User;
import com.example.wherever_i_want.mapper.RequestMapper;
import com.example.wherever_i_want.service.RequestService;
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
@WebMvcTest(RequestController.class)
public class RequestControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RequestMapper mapper;
    @MockBean
    private RequestService service;

    @Test
    public void shouldDeleteRequest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/whereverIWant/request/deleteUserRequestById/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCreateRequest() throws Exception {

        Request request = new Request();
        RequestDto requestDto = new RequestDto(1, 1, 1, "1", "country1", "date1");

        when(mapper.mapToRequestDto(any(Request.class))).thenReturn(requestDto);
        when(mapper.mapToRequestDto(any())).thenReturn(requestDto);
        when(service.save(request)).thenReturn(request);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(request);

        mockMvc.perform(post("/whereverIWant/request/createRequest")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.month", is("1")))
                .andExpect(jsonPath("$.country", is("country1")))
                .andExpect(jsonPath("$.requestDate", is("date1")));
    }

    @Test
    public void shouldUpdateRequest() throws Exception {

        User user = new User();
        user.setId(1);
        Request request = new Request(1, user, 1, "1", "country1", "date1");
        RequestDto requestDto = new RequestDto(1, 2, 2, "updated", "updated", "updated");

        when(service.findById(request.getId())).thenReturn(request);
        when(mapper.mapToRequestDto(any(Request.class))).thenReturn(requestDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(requestDto);

        mockMvc.perform(put("/whereverIWant/request/updateRequest")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetRequest() throws Exception {
        User user = new User();
        user.setId(1);
        Request request = new Request(1, user, 1, "1", "country1", "date1");
        RequestDto requestDto = new RequestDto(1, 1, 1, "1", "country1", "date1");
        List<Request> list = new ArrayList<>();
        List<RequestDto> dtos = new ArrayList<>();
        list.add(request);
        dtos.add(requestDto);

        when(service.findById(request.getId())).thenReturn(request);
        when(mapper.mapToRequestDto(any(Request.class))).thenReturn(requestDto);
        when(service.getAll()).thenReturn(list);
        when(mapper.getRequestDtoList(anyList())).thenReturn(dtos);

        mockMvc.perform(get("/whereverIWant/request/getRequestByID/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void shouldGetAllRequests() throws Exception {

        RequestDto requestDto1 = new RequestDto(1, 1, 1, "1", "country1", "date1");
        RequestDto requestDto2 = new RequestDto(2, 2, 2, "2", "country2", "date2");
        List<RequestDto> list = new ArrayList<>();
        list.add(requestDto1);
        list.add(requestDto2);

        when(mapper.getRequestDtoList(anyList())).thenReturn(list);

        mockMvc.perform(get("/whereverIWant/request/getAllRequests")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void shouldFetchEmptyRequestsList() throws Exception {
        List<Request> list = new ArrayList<>();
        List<RequestDto> dtoList = new ArrayList<>();

        when(service.getAll()).thenReturn(list);
        when(mapper.getRequestDtoList(anyList())).thenReturn(dtoList);
        mockMvc.perform(get("/whereverIWant/request/getAllRequests").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void contextLoads() {
    }
}
