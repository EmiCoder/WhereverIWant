package com.example.wherever_i_want.dao;

import com.example.wherever_i_want.domain.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface RequestDao extends CrudRepository<Request, Integer> {
    List<Request> findByCountry(String country);
}
