package com.wcci.masteryblog.blog.models;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Author {

	
	
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	
	@ManyToMany
	private Collection <Post> posts;
	
	public Author() {}
	
	public Author(String firstName, String lastName, Post ...posts) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.posts = Arrays.asList(posts);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Long getId() {
		return id;
	}

	public Collection<Post> getPosts() {
		return posts;
	}


	public void addPostToAuthorsPosts(Post post) {
		posts.add(post);	
	}

	public int getPostsLength() {
		int postsLength = posts.size();
		return postsLength;
	}
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", posts=" + posts + "]";
	}
	
	
	
	

}
