package com.example.wherever_i_want.service;

import com.example.wherever_i_want.domain.loginRegisterStaff.Register;
import com.example.wherever_i_want.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    public List<Register> getAll() {
        return registerRepository.findAll();
    }

    public Register findById(Integer id) {
        return registerRepository.findById(id).get();
    }

    public Register save(Register register) {
        return registerRepository.save(register);
    }

    public void deleteById(Integer id) {
        registerRepository.deleteById(id);
    }
}
