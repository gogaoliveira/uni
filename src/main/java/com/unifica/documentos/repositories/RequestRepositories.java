package com.unifica.documentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unifica.documentos.entity.Request;

@Repository
public interface RequestRepositories extends JpaRepository<Request, Integer> {

}
