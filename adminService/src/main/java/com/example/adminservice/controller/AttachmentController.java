package com.example.adminservice.controller;

import com.example.adminservice.dto.ApiResponse;
import com.example.adminservice.entity.Attachment;
import com.example.adminservice.repository.AttachmentRepository;
import com.example.adminservice.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.Long;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class AttachmentController {
    private final AttachmentRepository attachmentRepository;
    private final AttachmentService attachmentService;
    private final Path root = Paths.get("D:\\Java\\Fast Food\\botService\\src\\main\\resources\\upload");
    @PostMapping("/upload")
    public ResponseEntity<?> upload(MultipartHttpServletRequest request) {
        ApiResponse apiResponse = attachmentService.uploadFileSystem(request);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<?> getFile(@PathVariable Long id) {
        Attachment attachment = attachmentRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        Path file = root.resolve(attachment.getFileName());
        Resource resource = new UrlResource(file.toUri());
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(attachment.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attachment.getFileName() + "\"")
                .body(resource);
    }

    //filesave DB
    @PostMapping("/uploadDB")
    public ResponseEntity<?> saveToDB(MultipartHttpServletRequest request) {
        ApiResponse response = attachmentService.uploadDB(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/downloadDB/{attachmentId}")
    public ResponseEntity<?> downloadDB(@PathVariable(value = "attachmentId") Long id) {
       return attachmentService.downloadDB(id);
    }

    @GetMapping("/qollanma")
    public ResponseEntity<?> qollanma() {
        String fileName = "Qo`llanma";
        return attachmentService.attachmentFromFileName(fileName);
    }

    @GetMapping("/ofertaShartlari")
    public ResponseEntity<?> ofertaSharti() {
        String fileName = "Oferta Shartlari";
        return attachmentService.attachmentFromFileName(fileName);
    }

}
