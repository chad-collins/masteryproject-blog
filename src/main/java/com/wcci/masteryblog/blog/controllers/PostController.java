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
	model.addAttribute("authors", authorsRepo.findAll());
	model.addAttribute("genres", genreRepo.findAll());
	return"/addpost";
	}
	
	@PostMapping("/addpost")
	public String addPost(String lastName, String genreName, String postTitle, String postContent) {
	Genre genre = genreRepo.findByGenreName(genreName);
	Author author = authorsRepo.findByLastName(lastName);
	postsRepo.save(new Post(postTitle, author, genre, postContent));
		return"redirect:/";
	}
	
	
	
/*	@PostMapping("/submit")
	public String reviewSubmit(Beer beer, String review, String title, String date, int rating, String type,
		String beerName, String beerType, String brewery, String imgUrl, String tags) {
		Category categoryToMake = categories.findByBeerType(beerType);
		categoryToMake = categories.save(categoryToMake);
		Beer beerToMake = beers.findByBeerNameAndBrewery(beerName, brewery);
		if (beerToMake == null) {
			beerToMake = beers.save(new Beer(beerName, categoryToMake, brewery, imgUrl));
		}
		beerToMake = beers.save(beerToMake);
		reviews.save(new Review(beerToMake, review, title, date, rating));
		return "redirect:/";
	}*/
	
	
	
	@GetMapping("/{id}")
	public String viewPost(@PathVariable Long id, Model model) {
	model.addAttribute("post", postsRepo.findById(id).get());
	return"singlepost";
	}

		
}