package com.geotoolkit.gmreader.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FileUploadController {

    /**
     * Reads gravity model file.
     *
     * @param file with harmonic coefficients.
     * @return information about file.
     */
  @PostMapping("/single-file-upload")
  public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {

    Map<String, String> model1 = new HashMap<>();

    model1.put("fileName", file.getOriginalFilename());
    model1.put("fileSize", String.valueOf(file.getSize()));
    model1.put("fileContentType", file.getContentType());

    model1.put("message", "File upload done");
    return ResponseEntity.ok(model1);
  }

}

