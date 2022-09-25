package com.unifica.documentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifica.documentos.entity.documents.CarteiraTrabalho;

@Repository
public interface TrabalhoRepositories extends JpaRepository<CarteiraTrabalho, Integer> {

}
