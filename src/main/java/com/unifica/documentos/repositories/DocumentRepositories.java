package com.unifica.documentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unifica.documentos.entity.Document;

@Repository
public interface DocumentRepositories extends JpaRepository<Document, Integer> {

}
