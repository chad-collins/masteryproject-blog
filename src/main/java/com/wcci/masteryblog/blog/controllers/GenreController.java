package com.wcci.masteryblog.blog.controllers;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcci.masteryblog.blog.models.Genre;
import com.wcci.masteryblog.blog.repositories.GenreRepository;

@Controller
@RequestMapping("/genres")
public class GenreController {
	
	@Resource
	GenreRepository genreRepo;
	
	@GetMapping("")
	public String viewAllGenres(Model model) {
	model.addAttribute("genres", genreRepo.findAll());
	return"genres";
	}
	
	@PostMapping("/addgenre")
	public String addGenre(Model model, String genreName) {
	model.addAttribute(genreRepo.findAll());
	Genre genreToAdd = new Genre(genreName);
	genreRepo.save(genreToAdd);
	return"redirect:/genres";
	}

}
