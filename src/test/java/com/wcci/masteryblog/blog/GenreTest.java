package com.wcci.masteryblog.blog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wcci.masteryblog.blog.models.Genre;
import com.wcci.masteryblog.blog.models.Post;
import com.wcci.masteryblog.blog.repositories.GenreRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class GenreTest {

	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	GenreRepository genreRepo;
	
	@Test
	public void shouldSaveGenreToGenres() {
		Genre genre = genreRepo.save(new Genre("Tech"));
		
		entityManager.persist(genre);
		entityManager.flush();
		entityManager.clear();
		
		Long idToFind = 1L;
		Genre genreFromDB = genreRepo.findById(idToFind).get();
		
		assertThat(genreFromDB.getId(), is(1L));
	}
}
