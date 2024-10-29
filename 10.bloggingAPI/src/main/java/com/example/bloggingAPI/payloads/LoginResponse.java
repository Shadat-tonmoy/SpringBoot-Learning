package com.example.bloggingAPI.payloads;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginResponse {

    private String accessToken;
    private String refreshToken;
    private long expiresIn;
}
