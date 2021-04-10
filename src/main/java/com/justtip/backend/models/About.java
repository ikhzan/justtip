package com.justtip.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class About implements Serializable {

    @Id
    private String title;
    private String message;
    private boolean status;

    public About(String title, String message, boolean status) {
        this.title = title;
        this.message = message;
        this.status = status;
    }

    @Override
    public String toString() {
        return "About{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
