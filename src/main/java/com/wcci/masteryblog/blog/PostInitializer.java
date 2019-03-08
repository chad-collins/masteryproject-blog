package com.wcci.masteryblog.blog;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.wcci.masteryblog.blog.models.Post;
import com.wcci.masteryblog.blog.repositories.PostsRepository;

@Service
public class PostInitializer implements CommandLineRunner {

	
	@Resource
	PostsRepository postsRepo;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		postsRepo.save(new Post("This is a post tile", "This is a post yada yada"));
		
		
		
	}
	
}
