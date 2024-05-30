package com.example.bloggingAPI.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    private int id;

    @NotEmpty(message = "Post title must not be empty")
    private String title;

    @NotEmpty(message = "Post content must not be empty")
    private String content;

    private String imageName = "default.png";
    private long lastUpdated;

    private UserDto user;

    private CategoryDto category;
}
