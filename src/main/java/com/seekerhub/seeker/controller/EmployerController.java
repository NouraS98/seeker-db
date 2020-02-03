package com.seekerhub.seeker.controller;

import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.service.employer.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employer")
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @PostMapping
    public ResponseEntity create(@RequestBody EmployerDto employer) {
        return ResponseEntity.ok(employerService.save(employer));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(employerService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(employerService.findById(id));
    }

}
