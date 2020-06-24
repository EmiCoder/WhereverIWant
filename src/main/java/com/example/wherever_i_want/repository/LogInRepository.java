package com.example.wherever_i_want.repository;

import com.example.wherever_i_want.domain.loginRegisterStaff.LogIn;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LogInRepository extends CrudRepository<LogIn, Integer> {

    @Override
    List<LogIn> findAll();

    @Override
    LogIn save(LogIn logIn);

    @Override
    Optional<LogIn> findById(Integer logInId);

    @Override
    void deleteById(Integer logInId);
}

