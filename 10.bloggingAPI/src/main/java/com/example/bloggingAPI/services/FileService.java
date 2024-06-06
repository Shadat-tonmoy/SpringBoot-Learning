package com.example.bloggingAPI.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    String uploadImage(String destinationPath, MultipartFile file) throws IOException;
}
