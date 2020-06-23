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

    @PostMapping(value = "/createUser")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.save(userMapper.mapToUser(userDto)));
    }

    @PutMapping(value = "/updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.save(userMapper.mapToUser(userDto)));
    }

    @DeleteMapping(value = "deleteUserById/{id}")
    public void deleteUserById(@PathVariable Integer id) {

    }
}
