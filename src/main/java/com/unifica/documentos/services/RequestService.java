package com.unifica.documentos.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifica.documentos.dto.RequestDTO;
import com.unifica.documentos.dto.RequestNewDTO;
import com.unifica.documentos.entity.Request;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.enums.StateRequest;
import com.unifica.documentos.repositories.RequestRepositories;
import com.unifica.documentos.repositories.UserRepositories;
import com.unifica.documentos.services.exceptions.ObjectNotFoundException;

@Service
public class RequestService {

    @Autowired
    private RequestRepositories requestRepositories;
    
    @Autowired
    private UserRepositories userRepositories;
    
    @Autowired
    private UserService userService;
    
    public Request find(Integer id){
        Optional<Request> obj = requestRepositories.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
        		"Pedido não existe"));
    }
    
    public List<Request>findAllByUserCompany(Integer company) {
    	User comp = userService.find(company);
    	return requestRepositories.findAllByUserCompany(comp);
    }
    
    public List<RequestDTO>findAllByUser(Integer objUser) {
    	User user = userService.find(objUser);
    	List<Request> list = requestRepositories.findAllByUser(user);
    	List<RequestDTO> req = fromRequestDto(list);
    	return req;
    }
    
    public Request insertResquest(Request objRequest) {
    	objRequest.setId(null);
    	return requestRepositories.save(objRequest);
    }
    
    public Request updateRequest(Request objRequest) {
    	find(objRequest.getId());
    	return requestRepositories.save(objRequest);
    }
    
    /*
     * public User updateUser(User objUser) {
		find(objUser.getId());
		return userRepositories.save(objUser);
	}
     * */
    
    public Request fromDto(RequestNewDTO dto) {
    	User user = userRepositories.findByEmail(dto.getEmail());   	
    	if (user == null) {
			throw new ObjectNotFoundException("Usuario não encontrado");
		}
    	User company = userService.find(dto.getCompany());  	
    	Date date = new Date();
    	return new Request(null, date, StateRequest.AWAIT, user, company);
    }
    
    public List<RequestDTO> fromRequestDto(List<Request> objList) {
    	List<RequestDTO> list = new ArrayList<RequestDTO>();
    	for (Request req : objList) {
    		list.add(new RequestDTO(req.getId(), req.getDate(), req.getState(), req.getUserCompany()));
    	}
    	return list;
    }
    
    

}
