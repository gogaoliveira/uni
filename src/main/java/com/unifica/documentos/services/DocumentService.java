package com.unifica.documentos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifica.documentos.entity.Document;
import com.unifica.documentos.repositories.DocumentRepositories;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepositories documentRepositories;

    public Document find(Integer id){
        Optional<Document> obj = documentRepositories.findById(id);
        return obj.orElse(null);
    }
}
