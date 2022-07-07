package com.unifica.documentos.resource;

import com.unifica.documentos.entity.User;
import com.unifica.documentos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UserResource {

	@Autowired
	private UserService userService;
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		User obj = userService.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
