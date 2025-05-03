package com.miguelmfr.qrcode_generate.controller;

import com.google.zxing.WriterException;
import com.miguelmfr.qrcode_generate.dto.QrCodeGenereteRequestDTO;
import com.miguelmfr.qrcode_generate.dto.QrCodeGenereteResponseDTO;
import com.miguelmfr.qrcode_generate.service.QrCodeGenerateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGenerateService qrCodeGenerateService;

    public QrCodeController(QrCodeGenerateService qrCodeGenerateService) {
        this.qrCodeGenerateService = qrCodeGenerateService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenereteResponseDTO> generate(@RequestBody QrCodeGenereteRequestDTO request){
        try {
            QrCodeGenereteResponseDTO response =  this.qrCodeGenerateService.generateAndUploadQrCode(request.text());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
