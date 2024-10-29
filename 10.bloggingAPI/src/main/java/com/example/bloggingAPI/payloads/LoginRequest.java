package com.example.bloggingAPI.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LoginRequest {

    @NotEmpty(message = "User name must not be null or empty")
    private String userName;
    @NotEmpty(message = "Password must not be null or empty")
    private String password;
}
