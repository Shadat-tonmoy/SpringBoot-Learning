package com.example.bloggingAPI.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Category title must not be empty")
    private String title;

    @NotEmpty(message = "Category description must not be empty")
    private String description;
    private long lastModified;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    List<Post> postList = new ArrayList<>();
}
