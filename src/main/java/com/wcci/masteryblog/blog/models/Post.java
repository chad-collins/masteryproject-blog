package com.wcci.masteryblog.blog.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;


@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;
	private String postTitle;
	@Lob
	private String postContent;
	
	@ManyToMany(mappedBy="posts")
	private Collection <Author> authors;
	

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
		return "Post [id=" + id + ", postTitle=" + postTitle + ", postContent=" + postContent + ", authors=" + authors
				+ "]";
	}
	
	public Collection<Author> getAuthors() {
		return authors;
	}

	public void addAuthorToPostsAuthors(Author author) {
		authors.add(author);
		
	}

	
	
}
