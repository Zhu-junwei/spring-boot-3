package com.zjw.controller;

import com.zjw.service.MinioService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/minio")
@AllArgsConstructor
public class MinioController {

    private MinioService minioService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = minioService.uploadFile(file);
            return ResponseEntity.ok("File uploaded successfully: " + fileName);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) {
        try(InputStream fileStream = minioService.downloadFile(fileName)) {
            byte[] fileBytes = fileStream.readAllBytes();
            // 确定文件类型并设置适当的MediaType
            MediaType mediaType = getMediaTypeForFileName(fileName);
            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .body(fileBytes);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    private MediaType getMediaTypeForFileName(String fileName) {
        if (fileName.toLowerCase().endsWith(".png")) {
            return MediaType.IMAGE_PNG;
        } else if (fileName.toLowerCase().endsWith(".jpg") || fileName.toLowerCase().endsWith(".jpeg")) {
            return MediaType.IMAGE_JPEG;
        } else if (fileName.toLowerCase().endsWith(".gif")) {
            return MediaType.IMAGE_GIF;
        } else {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }
}
