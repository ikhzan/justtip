package com.justtip.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BlogCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date date;
    private Author author;

    public BlogCategory(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "BlogCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", author=" + author +
                '}';
    }
}
