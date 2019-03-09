package com.wcci.masteryblog.blog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcci.masteryblog.blog.models.Author;
import com.wcci.masteryblog.blog.models.Post;
import com.wcci.masteryblog.blog.repositories.AuthorsRepository;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	@Resource
	AuthorsRepository authorsRepo;
	
	
	@GetMapping("")
	public String viewAllAuthors(Model model) {
	model.addAttribute("authors", authorsRepo.findAll());
	return"authors";
	}
	
	@PostMapping("/addauthor")
	public String addPost(Model model, String firstName, String lastName) {
	model.addAttribute(authorsRepo.findAll());
	Author authorToAdd = new Author(firstName, lastName);
	authorsRepo.save(authorToAdd);
	return"redirect:/authors";
	}
}
