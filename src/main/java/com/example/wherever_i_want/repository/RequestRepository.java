package com.example.wherever_i_want.repository;

import com.example.wherever_i_want.domain.Request;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RequestRepository extends CrudRepository<Request, Integer> {
    @Override
    List<Request> findAll();

    @Override
    Request save(Request userRequest);

    @Override
    Optional<Request> findById(Integer userRequestId);

    @Override
    void deleteById(Integer userRequestId);
}
