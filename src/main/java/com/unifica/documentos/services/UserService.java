package com.unifica.documentos.services;

import com.unifica.documentos.entity.User;
import com.unifica.documentos.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositories userRepositories;

    public User find(Integer id){
        Optional<User> obj = userRepositories.findById(id);
        return obj.orElse(null);
    }
}
