package com.unifica.documentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unifica.documentos.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer>{
}

