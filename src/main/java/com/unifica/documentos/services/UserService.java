package com.unifica.documentos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.unifica.documentos.entity.User;
import com.unifica.documentos.repositories.UserRepositories;
import com.unifica.documentos.services.exceptions.DataIntegrityException;
import com.unifica.documentos.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepositories userRepositories;

	public User find(Integer id) {
		Optional<User> obj = userRepositories.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
						"Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}
	
	public User insertUser(User objUser) {
		objUser.setId(null);
		return userRepositories.save(objUser);
	}
	
	public User updateUser(User objUser) {
		find(objUser.getId());
		return userRepositories.save(objUser);
	}
	
	public void deleteUser(Integer id) {
		find(id);
		try {
			userRepositories.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir usuario que possui vinculos de pedidos");
		}
	}

}
