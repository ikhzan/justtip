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
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;
    private String email;
    private String date;
    private String name;
    private String website;

    public Comment(String message, String email,String name, String website) {
        this.message = message;
        this.email = email;
        this.name = name;
        this.website = website;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
