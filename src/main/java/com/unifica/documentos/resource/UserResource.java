package com.unifica.documentos.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifica.documentos.entity.User;

@RestController
@RequestMapping(value = "/documentos")
public class UserResource {

	@GetMapping
	public List<User> listar() {
		
		User u1 = new User(1, "Douglas", "foto/123", "email@email.com", "123");
		User u2 = new User(2, "flavia", "foto/abc", "teste@teste.com", "abc");
		
		List<User> lista = new ArrayList<>();
		
		lista.add(u1);
		lista.add(u2);
		
		return lista;
	}
}
