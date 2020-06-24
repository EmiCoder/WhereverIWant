package com.example.wherever_i_want.mapper;

import com.example.wherever_i_want.domain.dto.LogInDto;
import com.example.wherever_i_want.domain.loginRegisterStaff.LogIn;
import com.example.wherever_i_want.repository.UserRepository;
import com.example.wherever_i_want.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LogInMapper {

    @Autowired
    private LogInService logInService;
    @Autowired
    private UserRepository userRepository;

    public LogIn mapToLogIn(LogInDto logInDto) {
        return new LogIn(logInDto.getId(),
                            userRepository.findById(logInDto.getUserId()).get(),
                            logInDto.getLoginDate(),
                            logInDto.getLoginTime());
    }

    public LogInDto mapToLogInDto(LogIn logIn) {
        return new LogInDto(logIn.getId(),
                            logIn.getUser().getId(),
                            logIn.getLoginDate(),
                            logIn.getLoginTime());
    }

    public List<LogInDto> mapToLogInDtoList(List<LogIn> list) {
        return list.stream().map(logIn -> new LogInDto(logIn.getId(),
                                                logIn.getUser().getId(),
                                                logIn.getLoginDate(),
                                                logIn.getLoginTime()))
                            .collect(Collectors.toList());
    }
}
