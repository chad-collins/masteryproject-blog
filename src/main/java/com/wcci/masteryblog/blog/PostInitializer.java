package com.wcci.masteryblog.blog;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.wcci.masteryblog.blog.models.Author;
import com.wcci.masteryblog.blog.models.Post;
import com.wcci.masteryblog.blog.repositories.AuthorsRepository;
import com.wcci.masteryblog.blog.repositories.PostsRepository;

@Service
public class PostInitializer implements CommandLineRunner {

	
	@Resource
	PostsRepository postsRepo;
	@Resource
	AuthorsRepository authorsRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		//POST INITIALIZER//
		postsRepo.save(new Post("This is a post tile", "This is a post yada yada"));
		
		//AUTHOR INITIALIZER//
		authorsRepo.save(new Author("Chad", "Collins"));
		authorsRepo.save(new Author("Nick", "Miner"));
	}
	
}
