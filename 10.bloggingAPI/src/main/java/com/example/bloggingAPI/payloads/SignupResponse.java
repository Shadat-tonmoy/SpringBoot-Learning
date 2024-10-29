package com.example.bloggingAPI.payloads;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SignupResponse {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
}
