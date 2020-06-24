package com.example.wherever_i_want.controller;


import com.example.wherever_i_want.domain.dto.RegisterDto;
import com.example.wherever_i_want.mapper.RegisterMapper;
import com.example.wherever_i_want.repository.RegisterRepository;
import com.example.wherever_i_want.service.RegisterService;
import com.example.wherever_i_want.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/whereverIWant/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;
    @Autowired
    private RegisterMapper registerMapper;

    @GetMapping(value = "/getAllRegisters")
    public List<RegisterDto> getAllRegisters() {
        return registerMapper.mapToRegosterDtoList(registerService.getAll());
    }

    @GetMapping(value = "/getRegister/{id}")
    public RegisterDto getRegister(@PathVariable Integer id) {
        return registerMapper.mapToRegisterDto(registerService.findById(id));
    }

    @PostMapping(value = "/createRegister")
    public RegisterDto createRegister(@RequestBody RegisterDto registerDto,
                                      @RequestParam("nick") String nick,
                                      @RequestParam("firstname") String firstname,
                                      @RequestParam("lastname") String lastname,
                                      @RequestParam("age") int age,
                                      @RequestParam("eMail") String eMail,
                                      @RequestParam("password") String password) {
        return registerMapper.mapToRegisterDto(registerService.save(registerMapper.mapToRegister(registerDto,
                                                                                                    nick,
                                                                                                    firstname,
                                                                                                    lastname,
                                                                                                    age,
                                                                                                    eMail,
                                                                                                    password)));
    }

    @DeleteMapping(value = "deleteRegisterById/{id}")
    public void deleteRegisterById(@PathVariable Integer id) {
           registerService.deleteById(id);
    }

}
