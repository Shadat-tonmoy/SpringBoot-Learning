package com.example.bloggingAPI.payloads;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperationResponse {

    private boolean isSuccess;
    private String message;
}
