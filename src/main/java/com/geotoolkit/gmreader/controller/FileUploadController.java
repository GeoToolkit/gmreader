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

    Map<String, String> map = new HashMap<>();

    map.put("fileName", file.getOriginalFilename());
    map.put("fileSize", String.valueOf(file.getSize()));
    map.put("fileContentType", file.getContentType());

    map.put("message", "File upload done");
    return ResponseEntity.ok(map);
  }

}

