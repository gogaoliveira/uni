package com.unifica.documentos.repositories;

import com.unifica.documentos.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepositories extends JpaRepository<Document, Integer> {

}
