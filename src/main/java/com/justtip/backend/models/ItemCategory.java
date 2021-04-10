package com.justtip.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ItemCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Boolean status;
    private String createdBy;
    private String createdDate;

    public ItemCategory(String name, Boolean status, String createdBy, String createdDate) {
        this.name = name;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "ItemCategory{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
