package com.unifica.documentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifica.documentos.entity.documents.Endereco;

@Repository
public interface EnderecoRepositories extends JpaRepository<Endereco, Integer> {

}
