package com.wcci.masteryblog.blog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcci.masteryblog.blog.repositories.OctoRepository;

@Controller
@RequestMapping("/octothorps")
public class OctothorpController {
	
	@Resource
	OctoRepository octoRepo;

	@GetMapping("")
	public String viewAllAuthors(Model model) {
	model.addAttribute("tag", octoRepo.findAll());
	return"octothorps";
	}

}
