package com.example.wherever_i_want.mapper;

import com.example.wherever_i_want.domain.Request;
import com.example.wherever_i_want.domain.dto.RequestDto;
import com.example.wherever_i_want.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RequestMapper {

    @Autowired
    private UserService userService;

    public Request mapToRequest(RequestDto requestDto) {
        return new Request(requestDto.getId(),
                                userService.findById(requestDto.getUserId()),
                                requestDto.getTemperature(),
                                requestDto.getMonth(),
                                requestDto.getCountry(),
                                requestDto.getRequestDate());
    }

    public RequestDto mapToRequestDto(Request request) {
        return new RequestDto(request.getId(),
                                    request.getUser().getId(),
                                    request.getTemperature(),
                                    request.getMonth(),
                                    request.getCountry(),
                                    request.getRequestDate());
    }

    public List<RequestDto> getRequestDtoList(List<Request> list) {
        return list.stream().map(request -> new RequestDto(
                                                    request.getId(),
                                                    request.getUser().getId(),
                                                    request.getTemperature(),
                                                    request.getMonth(),
                                                    request.getCountry(),
                                                    request.getRequestDate()))
                .collect(Collectors.toList());
    }

}
