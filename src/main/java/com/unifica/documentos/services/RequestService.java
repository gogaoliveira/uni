package com.unifica.documentos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifica.documentos.entity.Request;
import com.unifica.documentos.repositories.RequestRepositories;

@Service
public class RequestService {

    @Autowired
    private RequestRepositories requestRepositories;

    public Request find(Integer id){
        Optional<Request> obj = requestRepositories.findById(id);
        return obj.orElse(null);
    }
}
