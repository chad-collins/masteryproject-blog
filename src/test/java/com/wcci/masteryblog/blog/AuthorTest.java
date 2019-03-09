package com.wcci.masteryblog.blog;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wcci.masteryblog.blog.models.Author;
import com.wcci.masteryblog.blog.models.Post;
import com.wcci.masteryblog.blog.repositories.AuthorsRepository;
import com.wcci.masteryblog.blog.repositories.PostsRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class AuthorTest {


	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	AuthorsRepository authorsRepo;
	
	@Resource
	PostsRepository postsRepo;
	


	
	@Test
	public void shouldSaveAuthorToDBandFindByFirstNameAndLastName() {
		Author author = authorsRepo.save(new Author("testFirst", "testLast"));
		
		
		
		entityManager.persist(author);
		entityManager.flush();
		entityManager.clear();
		
		
		Author authorFromDB = authorsRepo.findByFirstNameAndLastName("testFirst", "testLast");
		
		
		assertThat(authorFromDB.getFirstName(), is("testFirst"));
	}
	

	@Test
	public void shouldAddPostToAuthorsPosts() {
		Author author = authorsRepo.save(new Author("nameA", "nameB"));
		Post post = postsRepo.save(new Post("title", "content"));
		author.addPostToAuthorsPosts(post);
		post.addAuthorToPostsAuthors(author);
		authorsRepo.save(author);
		postsRepo.save(post);
		
		entityManager.persist(author);
		entityManager.flush();
		entityManager.clear();
		
		entityManager.persist(post);
		entityManager.flush();
		entityManager.clear();
		
		Author authorFromDB = authorsRepo.findByFirstNameAndLastName("nameA", "nameB");
		int answer = authorFromDB.getPostsLength();
		
		assertEquals(answer, 1);
		
		
	
	}
	
}
