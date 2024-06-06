package com.example.bloggingAPI.controllers;

import com.example.bloggingAPI.payloads.FileResponse;
import com.example.bloggingAPI.services.FileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(("api/v1/files"))
public class FileController {

    @Autowired
    private FileService fileService;

    @Value(("${project.image}"))
    private String imageFolderPath;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> uploadFile(@RequestParam("image") MultipartFile file) throws IOException {

        String uploadedFilePath = fileService.uploadImage(imageFolderPath,file);
        return new ResponseEntity<>(new FileResponse(uploadedFilePath,"File Uploaded Successfully!!",true), HttpStatus.OK);


    }


}
