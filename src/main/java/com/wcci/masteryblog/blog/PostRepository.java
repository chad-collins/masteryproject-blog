package com.wcci.masteryblog.blog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wcci.masteryblog.blog.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
