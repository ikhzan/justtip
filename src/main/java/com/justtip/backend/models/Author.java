package com.justtip.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String fullname;
    private String emailID;
    private String jobtitle;
    private String profileImageUrl;

    public Author(String fullname, String emailID, String jobtitle) {
        this.fullname = fullname;
        this.emailID = emailID;
        this.jobtitle = jobtitle;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", emailID='" + emailID + '\'' +
                ", jobtitle='" + jobtitle + '\'' +
                '}';
    }
}
