package com.example.bloggingAPI.payloads;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String about;


}
