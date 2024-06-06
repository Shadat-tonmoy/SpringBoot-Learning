package com.example.bloggingAPI.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileResponse {

    private String filePath;
    private String message;
    private boolean isSuccess;
}
