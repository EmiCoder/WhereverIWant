package com.example.wherever_i_want.mapper;

import com.example.wherever_i_want.domain.dto.RegisterDto;
import com.example.wherever_i_want.domain.loginRegisterStaff.Register;
import com.example.wherever_i_want.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RegisterMapper {

    @Autowired
    private UserService userService;

    public Register mapToRegister(RegisterDto registerDto) {
        return new Register(registerDto.getId(),
                            userService.findById(registerDto.getId()),
                            registerDto.getRegisterDate(),
                            registerDto.getRegisterTime());
    }

    public RegisterDto mapToRegisterDto(Register register) {
        return new RegisterDto(register.getId(),
                                register.getUser().getId(),
                                register.getRegisterDate(),
                                register.getRegisterTime());
    }

    public List<RegisterDto> mapToRegosterDtoList(List<Register> list) {
        return list.stream().map(register -> new RegisterDto(register.getId(),
                                                                register.getUser().getId(),
                                                                register.getRegisterDate(),
                                                                register.getRegisterTime()))
                            .collect(Collectors.toList());
    }

}
