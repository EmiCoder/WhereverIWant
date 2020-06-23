package com.example.wherever_i_want.dao;

import com.example.wherever_i_want.domain.loginRegisterStaff.Register;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface RegisterDao extends CrudRepository<Register, Integer> {
    List<Register> findByUserId(Integer userId);
}
