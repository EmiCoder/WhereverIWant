package com.example.wherever_i_want.dao;

import com.example.wherever_i_want.domain.loginRegisterStaff.LogIn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface LogInDao extends CrudRepository<LogIn, Integer> {
    List<LogIn> findByUserId(Integer userId);
}
