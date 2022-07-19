package com.unifica.documentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unifica.documentos.entity.Company;

@Repository
public interface CompanyRepositories extends JpaRepository<Company, Integer> {

}
