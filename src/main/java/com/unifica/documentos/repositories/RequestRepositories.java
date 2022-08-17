package com.unifica.documentos.repositories;

import com.unifica.documentos.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepositories extends JpaRepository<Request, Integer> {

}
