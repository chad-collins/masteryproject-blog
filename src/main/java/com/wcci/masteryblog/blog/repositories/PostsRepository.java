package com.wcci.masteryblog.blog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wcci.masteryblog.blog.models.Post;

@Repository
public interface PostsRepository extends CrudRepository<Post, Long> {

}
