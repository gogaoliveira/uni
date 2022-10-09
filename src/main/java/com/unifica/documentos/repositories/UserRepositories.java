package com.unifica.documentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unifica.documentos.entity.User;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer>{
	
	@Transactional(readOnly = true)
	User findByEmail(String email);
	
}

