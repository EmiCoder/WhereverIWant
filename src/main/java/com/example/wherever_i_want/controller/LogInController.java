package com.example.wherever_i_want.controller;


import com.example.wherever_i_want.domain.dto.LogInDto;
import com.example.wherever_i_want.domain.loginRegisterStaff.LogIn;
import com.example.wherever_i_want.mapper.LogInMapper;
import com.example.wherever_i_want.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/whereverIWant/logIn")
public class LogInController {

    @Autowired
    private LogInMapper logInMapper;
    @Autowired
    private LogInService logInService;

    @GetMapping(value = "/getAllLogsIn")
    public List<LogInDto> getAllLogs() {
        return logInMapper.mapToLogInDtoList(logInService.getAll());
    }

    @GetMapping(value = "/getLogInById/{id}")
    public LogInDto getLogIn(@PathVariable Integer id) {
        return logInMapper.mapToLogInDto(logInService.findById(id));
    }

    @GetMapping(value = "/getAllLogsByUserId/{userId}")
    public List<LogInDto> getAllLogsByUserId(@PathVariable Integer userId) {
        List<LogInDto> list = new ArrayList<>();
        for (LogIn logIn : logInService.getAll()) {
            if (logIn.getUser().getId() == userId) {
                list.add(logInMapper.mapToLogInDto(logIn));
            }
        } return list;
    }

    @PostMapping(value = "/createLogIn")
    public LogInDto createRegister(@RequestBody LogInDto logInDto) {
        return logInMapper.mapToLogInDto(logInService.save(logInMapper.mapToLogIn(logInDto)));
    }

    @DeleteMapping(value = "deleteLogInById/{id}")
    public void deleteLogInById(@PathVariable Integer id) {
        logInService.deleteById(id);
    }
}
