package com.wcci.masteryblog.blog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcci.masteryblog.blog.models.Author;
import com.wcci.masteryblog.blog.models.Octothorp;
import com.wcci.masteryblog.blog.repositories.AuthorsRepository;
import com.wcci.masteryblog.blog.repositories.GenreRepository;
import com.wcci.masteryblog.blog.repositories.OctoRepository;
import com.wcci.masteryblog.blog.repositories.PostsRepository;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	@Resource
	GenreRepository genreRepo;
	@Resource
	PostsRepository postsRepo;
	@Resource
	AuthorsRepository authorsRepo;
	@Resource 
	OctoRepository octoRepo;
	
	
	@GetMapping("")
	public String viewAllAuthors(Model model) {
	model.addAttribute("authors", authorsRepo.findAll());
	model.addAttribute("octothorps", octoRepo.findAll());
	return"authors";
	}
	
	@PostMapping("/addauthor")
	public String addPost(String firstName, String lastName) {
		Author authorToAdd = authorsRepo.findByFirstNameAndLastName(firstName, lastName);
		if(authorToAdd == null) {
			authorsRepo.save(new Author(firstName, lastName));}
	return"redirect:/authors";
	}
	
	
	
	
	@GetMapping("/{id}")
	public String viewAuthor(@PathVariable Long id, Model model) {
		model.addAttribute("author", authorsRepo.findById(id).get());
		model.addAttribute("posts", postsRepo.findAll());
		model.addAttribute("octothorps", octoRepo.findAll());
	return"singleauthor";
	}
}
