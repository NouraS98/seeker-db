package com.seekerhub.seeker.controller;

import com.seekerhub.seeker.dto.Certificate.CertificateDto;
import com.seekerhub.seeker.dto.Chat.ChatDto;
import com.seekerhub.seeker.service.Certificate.CertificateService;
import com.seekerhub.seeker.service.Chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/certificate")
public class CertificateController {
    @Autowired
    private CertificateService certificateService;

    @PostMapping("create")
    public ResponseEntity create(@RequestBody CertificateDto certificateDto) {
        return ResponseEntity.ok(certificateService.save(certificateDto));
    }

    @GetMapping("find-all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(certificateService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(certificateService.findById(id));
    }

}
