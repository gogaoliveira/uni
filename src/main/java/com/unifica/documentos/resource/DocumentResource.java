package com.unifica.documentos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifica.documentos.entity.Document;
import com.unifica.documentos.services.DocumentService;

@RestController
@RequestMapping(value = "/documentos")
public class DocumentResource {

	@Autowired
	private DocumentService documentService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Document obj = documentService.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
