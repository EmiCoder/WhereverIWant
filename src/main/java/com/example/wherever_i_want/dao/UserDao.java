package com.example.wherever_i_want.dao;

import com.example.wherever_i_want.domain.loginRegisterStaff.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    List<User> findByNick(String nick);
}
