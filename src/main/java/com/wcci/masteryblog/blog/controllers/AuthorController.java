package com.wcci.masteryblog.blog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcci.masteryblog.blog.repositories.AuthorsRepository;

@Controller
@RequestMapping("/allauthors")
public class AuthorController {

	@Resource
	AuthorsRepository authorsRepo;
	
	
	@GetMapping("/allauthors")
	public String viewAllAuthors(Model model) {
	model.addAttribute(authorsRepo.findAll());
	return"allauthors";
	}
}
