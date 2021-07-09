package com.justtip.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tag implements Serializable {

    @Id
    private long id;
    private String name;
    private BlogCategory blogCategory;
    private Date createdDate;
    private Author author;

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogCategory=" + blogCategory +
                ", createdDate=" + createdDate +
                ", author=" + author +
                '}';
    }
}
