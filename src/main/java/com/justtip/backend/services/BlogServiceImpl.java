package com.justtip.backend.services;

import com.justtip.backend.models.Blog;
import com.justtip.backend.repo.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepo blogRepo;

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    @Override
    public void saveBlog(Blog blog) {
        this.blogRepo.save(blog);
    }

    @Override
    public Blog getBlogById(long id) {
        return null;
    }

    @Override
    public void deleteBlogById(long id) {

    }
}
