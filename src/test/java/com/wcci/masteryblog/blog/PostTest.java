package com.wcci.masteryblog.blog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.wcci.masteryblog.blog.models.Post;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class PostTest {
	
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	PostRepository postRepo;
	
	
	@Test
	public void shouldSavePostToPosts() {
		Post post = postRepo.save(new Post("title", "content"));
		
		entityManager.persist(post);
		entityManager.flush();
		entityManager.clear();
		
		Long idToFind = 1L;
		Post postFromDB = postRepo.findById(idToFind).get();
		
		assertThat(postFromDB.getId(), is(1L));
	}
	
	/*
	@Test
	public void shouldGetTitleFromPostInDB() {
		Post post2 = postRepo.save(new Post("title", "content"));
		
		entityManager.persist(post2);
		entityManager.flush();
		entityManager.clear();
		
		Long idToFind = 2L;
		Post postFromDB = postRepo.findById(idToFind).get();
		
		assertThat(postFromDB.getPostTitle(), is("title"));
	}
	*/
	

}
