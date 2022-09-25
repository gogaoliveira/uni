package com.unifica.documentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifica.documentos.entity.documents.TituloEleitor;

@Repository
public interface EleitorRepositories extends JpaRepository<TituloEleitor, Integer> {

}
