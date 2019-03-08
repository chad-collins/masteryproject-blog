package com.wcci.masteryblog.blog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wcci.masteryblog.blog.models.Post;
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
	
	@PostMapping("/addpost")
	public String addPost(Model model, String postTitle, String postContent) {
	model.addAttribute(postsRepo.findAll());
	Post postToAdd = new Post(postTitle, postContent);
	postsRepo.save(postToAdd);
	return"/addpost";
	}
		
}