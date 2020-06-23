package com.example.wherever_i_want.repository;

import com.example.wherever_i_want.domain.loginRegisterStaff.Register;
import com.example.wherever_i_want.domain.loginRegisterStaff.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RegisterRepository extends CrudRepository<Register, Integer> {

    @Override
    List<Register> findAll();

    @Override
    Register save(Register register);

    @Override
    Optional<Register> findById(Integer registerId);

    @Override
    void deleteById(Integer registerId);
}
