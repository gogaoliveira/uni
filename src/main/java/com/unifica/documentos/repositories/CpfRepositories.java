package com.unifica.documentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifica.documentos.entity.documents.Cpf;

@Repository
public interface CpfRepositories extends JpaRepository<Cpf, Integer> {

}
