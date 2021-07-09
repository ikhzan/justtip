package com.justtip.backend.repo;

import com.justtip.backend.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Long> {
    List<Blog> findByTitle(String title);
}
