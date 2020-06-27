package com.example.wherever_i_want.controller;

import com.example.wherever_i_want.domain.dto.RequestDto;
import com.example.wherever_i_want.mapper.RequestMapper;
import com.example.wherever_i_want.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/whereverIWant/request")
public class RequestController {

    @Autowired
    private RequestMapper mapper;
    @Autowired
    private RequestService service;

    @GetMapping(value = "/getAllRequests")
    public List<RequestDto> getAllRequests() {
        return mapper.getRequestDtoList(service.getAll());
    }

    @GetMapping(value = "/getRequestByID/{id}")
    public RequestDto getRequestById(@PathVariable Integer id) {
        return mapper.mapToRequestDto(service.findById(id));
    }

    @PostMapping(value = "/createRequest")
    public RequestDto createUserRequestDto(@RequestBody RequestDto userRequestDto) {
        return mapper.mapToRequestDto(service.save(mapper.mapToRequest(userRequestDto)));
    }

    @PutMapping(value = "/updateRequest")
    public RequestDto updateRequest(@RequestBody RequestDto requestDto) {
        return mapper.mapToRequestDto(service.save(mapper.mapToRequest(requestDto)));
    }

    @DeleteMapping(value = "deleteUserRequestById/{id}")
    public void deleteUserRequestById(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
