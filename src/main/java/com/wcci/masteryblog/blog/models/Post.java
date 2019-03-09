package com.wcci.masteryblog.blog.models;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;
	private String postTitle;
	private LocalDateTime date;
	@Lob
	private String postContent;
	@ManyToMany
	private Collection <Author> authors;
	@ManyToOne
	private Genre genre;
	
	
	public Post() {}

	public Post(String postTitle, Author author, Genre genre, String postContent) {
		this.postTitle = postTitle;
		this.postContent =postContent;
		this.date = LocalDateTime.now();
		this.authors = Arrays.asList(author);
		this.genre = genre;
	}

	
	public LocalDateTime getDate() {
		return date;
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
	
	public Collection<Author> getAuthors() {
		return authors;
	}

	public Genre getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", postTitle=" + postTitle + ", date=" + date + ", postContent=" + postContent
				+ ", authors=" + authors + ", genre=" + genre + "]";
	}
	
	

	
	
}
