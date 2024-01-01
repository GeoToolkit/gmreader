package com.geotoolkit.gmreader.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Controller
public class FileUploadController {

    @PostMapping("/single-file-upload")
    public ResponseEntity<Map<String, String>> handleFileUploadUsingCurl(
            @RequestParam("file") MultipartFile file) throws IOException {

        Map<String, String> map = new HashMap<>();


        Scanner scanner = new Scanner(file.getInputStream());
//        while(scanner.hasNextLine()) {
//            System.out.println(scanner.nextLine());
//        }

        // Populate the map with file details
        map.put("fileName", file.getOriginalFilename());
        map.put("fileSize", String.valueOf(file.getSize()));
        map.put("fileContentType", file.getContentType());

        // File upload is successful
        map.put("message", "File upload done");
        return ResponseEntity.ok(map);
    }

}

