package com.unifica.documentos.dto;

import java.io.Serializable;
import java.util.Date;

import com.unifica.documentos.entity.enums.StateRequest;

public class RequestPutDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date date;
	private StateRequest state;
	private Integer user;
	private Integer userCompany;

	public RequestPutDTO() {
	}

	public RequestPutDTO( Date date, StateRequest state, Integer user, Integer userCompany) {
		super();
		this.date = date;
		this.state = state;
		this.user = user;
		this.userCompany = userCompany;
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

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getUserCompany() {
		return userCompany;
	}

	public void setUserCompany(Integer userCompany) {
		this.userCompany = userCompany;
	}

}
