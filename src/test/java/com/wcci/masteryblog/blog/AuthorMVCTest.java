package com.wcci.masteryblog.blog;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.wcci.masteryblog.blog.controllers.AuthorController;
import com.wcci.masteryblog.blog.models.Author;
import com.wcci.masteryblog.blog.repositories.AuthorsRepository;
import com.wcci.masteryblog.blog.repositories.GenreRepository;
import com.wcci.masteryblog.blog.repositories.OctoRepository;
import com.wcci.masteryblog.blog.repositories.PostsRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorMVCTest<Portfolio> {

	@Resource
	private MockMvc mvc;

	@MockBean
	private PostsRepository postRepo;

	@MockBean
	private AuthorsRepository authorsRepo;

	@MockBean
	private GenreRepository genreRepo;

	@MockBean
	private OctoRepository octoRepo;

	@Mock
	private Author author;

	@Test
	public void shouldRouteToIndiviualAuthorView() throws Exception {
		Long authorId = 1L;
		when(authorsRepo.findById(authorId)).thenReturn(Optional.of(author));
		mvc.perform(get("/authors/1")).andExpect(view().name(is("singleauthor")));
	}

	@Test
	public void shouldBeOkForIndividualAuthor() throws Exception {
		Long authorId = 1L;
		when(authorsRepo.findById(authorId)).thenReturn(Optional.of(author));
		mvc.perform(get("/authors/1")).andExpect(status().isOk());
	}

	@Test
	public void shouldPutSingleAuthorIntoModel() throws Exception {
		Long authorId = 1L;
		when(authorsRepo.findById(authorId)).thenReturn(Optional.of(author));
		mvc.perform(get("/authors/1")).andExpect(model().attribute("author", is(author)));
	}
}
