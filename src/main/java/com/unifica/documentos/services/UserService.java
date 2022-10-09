package com.unifica.documentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unifica.documentos.dto.UserNewDTO;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.repositories.UserRepositories;
import com.unifica.documentos.security.UserSS;
import com.unifica.documentos.services.exceptions.DataIntegrityException;
import com.unifica.documentos.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UserRepositories userRepositories;

	public List<User> findAll() {
		return userRepositories.findAll();
	}

	public User find(Integer id) {

		//UserSS user = UserService.authenticated();

		/*if (user == null || !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso Negado");
		}*/
		Optional<User> obj = userRepositories.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Usuario não encontrado! Id: " + id));
	}

	public User insertUser(User objUser) {
		objUser.setId(null);
		objUser.setPassword(encoder.encode(objUser.getPassword()));
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
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir usuario que possui vinculos de pedidos");
		}
	}

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

	public User fromDto(UserNewDTO userDto) {
		return new User(null, userDto.getName(), "photoExemplo", userDto.getCpf(), userDto.getEmail(), userDto.getPassword(), userDto.getProfile());
	}

}
