package com.unifica.documentos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unifica.documentos.entity.Request;
import com.unifica.documentos.entity.User;

@Repository
public interface RequestRepositories extends JpaRepository<Request, Integer> {
	
	@Transactional(readOnly = true)
	List<Request> findAllByUserCompany(User user);
	
	@Transactional(readOnly = true)
	List<Request> findAllByUser(User user);

}
