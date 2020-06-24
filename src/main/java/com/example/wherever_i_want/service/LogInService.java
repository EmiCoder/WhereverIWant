package com.example.wherever_i_want.service;

import com.example.wherever_i_want.domain.loginRegisterStaff.LogIn;
import com.example.wherever_i_want.repository.LogInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogInService {

    @Autowired
    private LogInRepository logInRepository;

    public List<LogIn> getAll() {
        return logInRepository.findAll();
    }

    public LogIn findById(Integer id) {
        return logInRepository.findById(id).get();
    }

    public LogIn save(LogIn logIn) {
        return logInRepository.save(logIn);
    }

    public void deleteById(Integer id) {
        logInRepository.deleteById(id);
    }
}
