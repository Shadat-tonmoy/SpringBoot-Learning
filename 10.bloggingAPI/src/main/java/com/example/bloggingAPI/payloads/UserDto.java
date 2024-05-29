package com.example.bloggingAPI.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    private int id;
    @NotNull(message = "First Name field should not be null or empty")
    @NotEmpty(message = "First Name field should not be null or empty")
    @Size(max = 50, message = "Length Should be between 0 and 50")
    private String firstName;


    @NotNull(message = "Last Name field should not be null or empty")
    @NotEmpty(message = "Last Name field should not be null or empty")
    @Size(max = 50, message = "Length Should be between 0 and 50")
    private String lastName;


    @NotNull(message = "Email field should not be null or empty")
    @NotEmpty(message = "Email field should not be null or empty")
    @Email
    @Size(min = 4, max = 50, message = "Length Should be between 4 and 50")
    private String email;


    @NotNull(message = "Password field should not be null or empty")
    @NotEmpty(message = "Password field should not be null or empty")
    @Size(min = 4, max = 50, message = "Length Should be between 4 and 50")
    private String password;


    @NotNull(message = "About field should not be null or empty")
    @NotEmpty(message = "About field should not be null or empty")
    private String about;


}
