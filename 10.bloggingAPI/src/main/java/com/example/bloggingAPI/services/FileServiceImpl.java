package com.example.bloggingAPI.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.InetAddress;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String destinationPath, MultipartFile file) throws IOException {


        // extract file name
        String originalFileName = file.getOriginalFilename();

        String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + originalFileExtension;


        // generate full path
        String filePath = destinationPath + File.separator + newFileName;

        // create folder if not exists
        File outputFolder = new File(destinationPath);
        File outputFile = new File(filePath);
        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
        }
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }

        // copy file

        OutputStream outStream = new FileOutputStream(outputFile);

        byte[] buffer = new byte[8 * 1024];
        int bytesRead;
        InputStream inputStream = file.getInputStream();
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outStream.close();

        System.out.println("Upload image will copy file with size : " + outputFile.length());

        String hostAddress = InetAddress.getLocalHost().getHostAddress();

        return outputFile.getPath();
    }
}
