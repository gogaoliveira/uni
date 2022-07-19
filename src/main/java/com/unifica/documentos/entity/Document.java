package com.unifica.documentos.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Documents")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String typeDocument;
	private String numberDocument;
	private String photoDocument;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Document() {
	}

	public Document(Integer id, String typeDocument, String numberDocument, String photoDocument, User user) {
		this.id = id;
		this.typeDocument = typeDocument;
		this.numberDocument = numberDocument;
		this.photoDocument = photoDocument;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}

	public String getNumberDocument() {
		return numberDocument;
	}

	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}

	public String getPhotoDocument() {
		return photoDocument;
	}

	public void setPhotoDocument(String photoDocument) {
		this.photoDocument = photoDocument;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
