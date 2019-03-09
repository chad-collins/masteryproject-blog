package com.wcci.masteryblog.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genre {

	@Id
	@GeneratedValue
	private Long id;
	private String genreName;
	
	public Genre() {}
	
	public Genre(String genreName) {
		this.id = id;
		this.genreName = genreName;
	}
	
	public Long getId() {
		return id;
	}
	public String getGenreName() {
		return genreName;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", genreName=" + genreName + "]";
	}
}
