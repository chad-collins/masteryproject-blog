package com.wcci.masteryblog.blog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcci.masteryblog.blog.models.Author;
import com.wcci.masteryblog.blog.models.Genre;
import com.wcci.masteryblog.blog.models.Post;
import com.wcci.masteryblog.blog.repositories.AuthorsRepository;
import com.wcci.masteryblog.blog.repositories.GenreRepository;
import com.wcci.masteryblog.blog.repositories.PostsRepository;


@Controller
@RequestMapping("/post")
public class PostController {

	@Resource
	PostsRepository postsRepo;
	@Resource
	AuthorsRepository authorsRepo;
	@Resource
	GenreRepository genreRepo;
	
	@GetMapping("/addpost")
	public String addPost(Model model) {
	model.addAttribute(postsRepo.findAll());
	return"/addpost";
	}
	
	@PostMapping("/addpost")
	public String addPost(Model model, String postTitle, String lastName, String genreName, String postContent) {
	model.addAttribute(postsRepo.findAll());
	Author author = authorsRepo.findByLastName(lastName);
	Genre genre = genreRepo.findByGenreName(genreName);
	postsRepo.save(new Post(postTitle, author, genre, postContent));
	return"/addpost";
	}
	
	@GetMapping("/{id}")
	public String viewPost(@PathVariable Long id, Model model) {
	model.addAttribute("post", postsRepo.findById(id).get());
	return"singlepost";
	}

		
}