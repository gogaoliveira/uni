package com.unifica.documentos.services;

import com.unifica.documentos.entity.Document;
import com.unifica.documentos.repositories.DocumentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepositories documentRepositories;

    public Document find(Integer id){
        Optional<Document> obj = documentRepositories.findById(id);
        return obj.orElse(null);
    }
}
