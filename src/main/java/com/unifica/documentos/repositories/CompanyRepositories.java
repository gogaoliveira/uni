package com.unifica.documentos.repositories;

import com.unifica.documentos.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepositories extends JpaRepository<Company, Integer> {

}
