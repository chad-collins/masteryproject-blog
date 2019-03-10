package com.wcci.masteryblog.blog.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Octothorp {

	@Id
	@GeneratedValue
	private Long id;
	private String tagName;
	@ManyToMany(mappedBy= "octos")
	private Collection<Post> posts;
	
	public Octothorp() {}
		
	public Octothorp(String tagName) {
		this.tagName = tagName;
	}
	
	public Long getId() {
		return id;
	}
	public String getTagName() {
		return tagName;
	}
	public Collection<Post> getPosts() {
		return posts;
	}
	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagName=" + tagName + ", posts=" + posts + "]";
	}
	
	
	
	
}
