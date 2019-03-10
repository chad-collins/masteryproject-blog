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
import com.wcci.masteryblog.blog.models.Genre;
import com.wcci.masteryblog.blog.models.Post;
import com.wcci.masteryblog.blog.repositories.AuthorsRepository;
import com.wcci.masteryblog.blog.repositories.GenreRepository;
import com.wcci.masteryblog.blog.repositories.PostsRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class GenreTest {

	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	GenreRepository genreRepo;
	@Resource
	PostsRepository postsRepo;
	@Resource
	AuthorsRepository authorsRepo;
	
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
	
	@Test
	public void shouldSavePostoGenresCollectionOfPosts() {
		Genre genre = genreRepo.save(new Genre("testGenre"));
		Author author = authorsRepo.save(new Author("name", "name1"));
		Post post = postsRepo.save(new Post("title", author, genre,"content"));
		
		
		entityManager.persist(genre);
		entityManager.flush();
		entityManager.clear();
		
		
		Genre genreFromDB = genreRepo.findByGenreName("testGenre");
		
		assertThat(genreFromDB.getPosts().size(), is(1));
	}
	
	
}
