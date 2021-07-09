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
public class Blogger implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String username;
    private String emailID;
    private String password;
    private Date date;

    public Blogger(String name, String username, String emailID, String password) {
        this.name = name;
        this.username = username;
        this.emailID = emailID;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Blogger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", emailID='" + emailID + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                '}';
    }
}
