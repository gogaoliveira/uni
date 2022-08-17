package com.unifica.documentos.resource;

import com.unifica.documentos.entity.Company;
import com.unifica.documentos.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/empresas")
public class CompanyResource {

	@Autowired
	private CompanyService companyService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Company obj = companyService.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
