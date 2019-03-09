package com.wcci.masteryblog.blog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcci.masteryblog.blog.models.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {

	Genre findByGenreName(String genreName);

}
