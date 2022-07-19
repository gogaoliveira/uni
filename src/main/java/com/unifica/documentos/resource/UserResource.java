package com.unifica.documentos.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unifica.documentos.entity.User;
import com.unifica.documentos.services.UserService;

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
	
	@PostMapping
	public ResponseEntity<Void> insertUser(@RequestBody User objUser){
		objUser = userService.insertUser(objUser);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(objUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> updateUser(@RequestBody User objUser, @PathVariable Integer id){
		objUser.setId(id);
		objUser = userService.updateUser(objUser);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
