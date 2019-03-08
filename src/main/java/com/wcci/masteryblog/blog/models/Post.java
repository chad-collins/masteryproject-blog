package com.wcci.masteryblog.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;
	private String postTitle;
	@Lob
	private String postContent;
	
	public Post() {}

	public Post(String postTitle, String postContent) {
		this.postTitle = postTitle;
		this.postContent =postContent;
	}

	
	public String getPostTitle() {
		return postTitle;
	}


	public String getPostContent() {
		return postContent;
	}


	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", postTitle=" + postTitle + ", postContent=" + postContent + "]";
	}
	
	
	
}
