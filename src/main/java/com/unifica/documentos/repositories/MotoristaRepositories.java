package com.unifica.documentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifica.documentos.entity.documents.CarteiraMotorista;

@Repository
public interface MotoristaRepositories extends JpaRepository<CarteiraMotorista, Integer> {

}
