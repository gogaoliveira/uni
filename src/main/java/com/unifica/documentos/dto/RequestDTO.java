package com.unifica.documentos.dto;

import java.io.Serializable;
import java.util.Date;

import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.enums.StateRequest;

public class RequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date date;
	private StateRequest state;
	private User userCompany;

	public RequestDTO() {
	}
	
	

	public RequestDTO(Integer id, Date date, StateRequest state, User userCompany) {
		super();
		this.id = id;
		this.date = date;
		this.state = state;
		this.userCompany = userCompany;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StateRequest getState() {
		return state;
	}

	public void setState(StateRequest state) {
		this.state = state;
	}

	public User getUserCompany() {
		return userCompany;
	}

	public void setUserCompany(User userCompany) {
		this.userCompany = userCompany;
	}

}
