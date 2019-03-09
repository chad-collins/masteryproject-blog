package com.wcci.masteryblog.blog.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {

	@Id
	@GeneratedValue
	private Long id;
	private String genreName;
	@OneToMany (mappedBy= "genre")
	private Collection<Post> posts;
	
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

	public Collection<Post> getPosts() {
		return posts;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", genreName=" + genreName + "]";
	}
}
