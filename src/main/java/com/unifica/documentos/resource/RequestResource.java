package com.unifica.documentos.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unifica.documentos.dto.RequestDTO;
import com.unifica.documentos.dto.RequestNewDTO;
import com.unifica.documentos.dto.RequestPutDTO;
import com.unifica.documentos.entity.Request;
import com.unifica.documentos.services.RequestService;
import com.unifica.documentos.services.UserService;

@RestController
@RequestMapping(value = "/pedidos")
public class RequestResource {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private UserService userService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Request obj = requestService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/company/{id}")
	public ResponseEntity<List<Request>> findAllByUserCompany(@PathVariable Integer id){
		List<Request> list = requestService.findAllByUserCompany(id);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/user/{id}")
	public ResponseEntity<List<RequestDTO>> findAllByUser(@PathVariable Integer id){
		List<RequestDTO> list = requestService.findAllByUser(id);
		return ResponseEntity.ok().body(list);
	}
	
	
	
	@PostMapping
	public ResponseEntity<Void> insertRequest(@RequestBody RequestNewDTO requestNewDTO){
		Request objRequest = requestService.fromDto(requestNewDTO);
		objRequest = requestService.insertResquest(objRequest);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objRequest.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> updateRequest(@RequestBody RequestPutDTO objRequest, @PathVariable Integer id){
		Request reqPut = new Request(id, objRequest.getDate(), objRequest.getState(), userService.find(objRequest.getUser()), userService.find(objRequest.getUserCompany()));
		reqPut = requestService.updateRequest(reqPut);
		return ResponseEntity.noContent().build();
	}
	
	
	
	/*
objRequest.setId(id);
		objRequest.setUser(userService.find(objRequest.getUser()));
		objRequest = requestService.updateRequest(objRequest);
		return ResponseEntity.noContent().build();
	}
	*/
	
}
