package com.wcci.masteryblog.blog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.wcci.masteryblog.blog.models.Octothorp;
import com.wcci.masteryblog.blog.repositories.OctoRepository;
import com.wcci.masteryblog.blog.repositories.PostsRepository;

@Controller
@RequestMapping("/octothorps")
public class OctothorpController {
	

	@Resource
	PostsRepository postsRepo;
	@Resource 
	OctoRepository octoRepo;
	
	@GetMapping("")
	public String viewAllOctothorps(Model model) {
		model.addAttribute("octothorps", octoRepo.findAll());
	return"octothorps";
	}
	

	@GetMapping("/{id}")
	public String viewSingleOctothorp(@PathVariable Long id, Model model) {
		model.addAttribute("octothorp", octoRepo.findById(id).get());
		model.addAttribute("posts", postsRepo.findAll());
		model.addAttribute("octothorps", octoRepo.findAll());
		return"singleoctothorp";
	}
	

	@PostMapping("/addoctothorp")
	public String addNewOctothorp(String tagName) {
		Octothorp octoToAdd = octoRepo.findByTagName(tagName);
		if(octoToAdd == null) {
		octoRepo.save(new Octothorp(tagName));}
		return"redirect:/octothorps";
	}

	
}
