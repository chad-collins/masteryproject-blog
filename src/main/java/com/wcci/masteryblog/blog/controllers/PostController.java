package com.wcci.masteryblog.blog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcci.masteryblog.blog.repositories.PostsRepository;

@Controller
@RequestMapping("/post")
public class PostController {

	@Resource
	PostsRepository postsRepo;
	
	@GetMapping("/addpost")
	public String addPost(Model model) {
	model.addAttribute(postsRepo.findAll());
	return"/addpost";
}
}