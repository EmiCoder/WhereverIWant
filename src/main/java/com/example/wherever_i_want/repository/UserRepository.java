package com.example.wherever_i_want.repository;

import com.example.wherever_i_want.domain.loginRegisterStaff.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    List<User> findAll();

    @Override
    User save(User task);

    @Override
    Optional<User> findById(Integer userId);

    @Override
    void deleteById(Integer userId);
}
