package com.justtip.backend.controllers;

import com.justtip.backend.exceptions.ResourceNotFoundException;
import com.justtip.backend.models.Author;
import com.justtip.backend.models.Blog;
import com.justtip.backend.models.BlogCategory;
import com.justtip.backend.repo.BlogRepo;
import com.justtip.backend.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BlogController {

    private static final String TAG = "BlogController";

    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private CommentRepo commentRepo;

    @GetMapping("blog/comment")
    public String comment(Model model){

        return "blogs/blog_single";
    }

    @GetMapping("blog")
    public String blog(Model model){
        List<Blog> blogs = blogRepo.findAll();
        model.addAttribute("section","blog");
        model.addAttribute("page-title","blog");
        model.addAttribute("blogs",blogs);
        return "blogs/blog";
    }

    @GetMapping("newblog")
    public String newBlog(Model model){
//        model.addAttribute("section","newblog");
//        model.addAttribute("page-title","new-blog");
//        Blog blog = new Blog();
//        model.addAttribute("blog",blog);
        return "blogs/newblog";
    }

    @PostMapping("saveblog")
    public String saveBlog(@ModelAttribute("blog") Blog blog, BindingResult result, Model model){
//        model.addAttribute("section","newblog");
//        model.addAttribute("page-title","new-blog");
//
//        if (result.hasErrors()){
//            return "blogs/newblog";
//        }
//        // dummy data auto
//        Author author = new Author();
//        author.setFullname("Mohammad Ikhsan");
//        author.setEmailID("ihsan@gmail.com");
//        author.setJobtitle("Developer");
//
//        blog.setAuthor(author);
//        blog.setImageUrl("img/team/team-1.jpg");
//        blog.setDate(new Date());
//
//        blogRepo.save(blog);

        return "blogs/blog";
    }


    @GetMapping("blog/{id}")
    public String getBlogById(@PathVariable("id") Long id, Model model){

        Blog blog = blogRepo.findById(id).orElseThrow( () ->
                new ResourceNotFoundException("Blog not exist with id: " + id));

        Author author = new Author();
        author.setFullname("Mohammad Ikhsan");
        author.setEmailID("ihsan@gmail.com");
        author.setJobtitle("Developer");

        List<BlogCategory> categories = new ArrayList<>();

        BlogCategory category = new BlogCategory();
        category.setDate(new Date());
        category.setAuthor(author);
        category.setName("Technology");
        categories.add(category);

        category = new BlogCategory();
        category.setDate(new Date());
        category.setAuthor(author);
        category.setName("News");
        categories.add(category);

        model.addAttribute("categories",categories);
        model.addAttribute("blog",blog);

        return "blogs/blog_single";
    }

    @GetMapping("blog-single")
    public String blogSingle(Model model){
        model.addAttribute("section","blog_single");
        model.addAttribute("page-title","single blog");

        Blog blog = blogRepo.findById(19L).orElseThrow( () ->
                new ResourceNotFoundException("Blog not exist with id: " + 18));

        model.addAttribute("blog",blog);

        Author author = new Author();
        author.setFullname("Mohammad Ikhsan");
        author.setEmailID("ihsan@gmail.com");
        author.setJobtitle("Developer");

        List<BlogCategory> categories = new ArrayList<>();

        BlogCategory category = new BlogCategory();
        category.setDate(new Date());
        category.setAuthor(author);
        category.setName("Technology");
        categories.add(category);

        category = new BlogCategory();
        category.setDate(new Date());
        category.setAuthor(author);
        category.setName("News");
        categories.add(category);

        model.addAttribute("author",author);
        model.addAttribute("categories",categories);

        List<Blog> blogs = blogRepo.findAll();
        model.addAttribute("blogs",blogs);

        return "blogs/blog_single";
    }



}
