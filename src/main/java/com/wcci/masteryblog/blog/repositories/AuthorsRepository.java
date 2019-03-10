package com.wcci.masteryblog.blog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wcci.masteryblog.blog.models.Author;

@Repository
public interface AuthorsRepository extends CrudRepository<Author, Long>{

	Author findByLastName(String lastName);

	Author findByFirstNameAndLastName(String firstName, String lastName);

}
