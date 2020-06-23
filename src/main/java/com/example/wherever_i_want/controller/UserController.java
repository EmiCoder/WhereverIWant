package com.example.wherever_i_want.controller;

import com.example.wherever_i_want.domain.dto.UserDto;
import com.example.wherever_i_want.mapper.UserMapper;
import com.example.wherever_i_want.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/whereverIWant/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/getAllUsers")
    public List<UserDto> getAllUsers() {
        return userMapper.getUserDtoList(userService.getAllUsers());
    }

    @GetMapping(value = "/getUser/{id}")
    public UserDto getUser(@PathVariable Integer id) {
        return userMapper.mapToUserDto(userService.findById(id));
    }
}
