package com.justtip.backend.services;

import com.justtip.backend.models.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getAllBlogs();
    void saveBlog(Blog blog);
    Blog getBlogById(long id);
    void deleteBlogById(long id);
}
