package com.example.wherever_i_want.service;

import com.example.wherever_i_want.domain.Request;
import com.example.wherever_i_want.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository repository;

    public List<Request> getAll() {
        return repository.findAll();
    }

    public Request findById(Integer id) {
        return repository.findById(id).get();
    }

    public Request save(Request userRequest) {
        return repository.save(userRequest);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
