package com.wcci.masteryblog.blog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wcci.masteryblog.blog.repositories.AuthorsRepository;
import com.wcci.masteryblog.blog.repositories.GenreRepository;
import com.wcci.masteryblog.blog.repositories.OctoRepository;
import com.wcci.masteryblog.blog.repositories.PostsRepository;

@Controller
public class HomeController {

	@Resource
	PostsRepository postsRepo;
	@Resource
	AuthorsRepository authorsRepo;
	@Resource
	GenreRepository genreRepo;
	@Resource 
	OctoRepository octoRepo;
	
@GetMapping("/")
public String home(Model model) {
	model.addAttribute("posts", postsRepo.findAll());
	model.addAttribute("octothorps", octoRepo.findAll());
	return "home";
	
}
	
}
