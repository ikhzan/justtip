package com.justtip.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OtherItem implements Serializable {
    @Id
    String id;

    String description;
}
