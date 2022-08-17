package com.unifica.documentos.services;

import com.unifica.documentos.entity.Company;
import com.unifica.documentos.repositories.CompanyRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepositories companyRepositories;

    public Company find(Integer id){
        Optional<Company> obj = companyRepositories.findById(id);
        return obj.orElse(null);
    }
}
