package com.unifica.documentos.services;

import com.unifica.documentos.entity.Request;
import com.unifica.documentos.repositories.RequestRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepositories requestRepositories;

    public Request find(Integer id){
        Optional<Request> obj = requestRepositories.findById(id);
        return obj.orElse(null);
    }
}
