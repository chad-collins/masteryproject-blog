package com.wcci.masteryblog.blog;


import static org.hamcrest.Matchers.is;
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

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class AuthorTest {


	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	AuthorsRepository authorsRepo;
	
	
	@Test
	public void shouldSaveAuthorToAuthors() {
		Author author = authorsRepo.save(new Author("firstName", "lastName"));
		
		entityManager.persist(author);
		entityManager.flush();
		entityManager.clear();
		
		Long idToFind = 1L;
		Author authorFromDB = authorsRepo.findById(idToFind).get();
		
		assertThat(authorFromDB.getFirstName(), is("firstName"));
	}
}
