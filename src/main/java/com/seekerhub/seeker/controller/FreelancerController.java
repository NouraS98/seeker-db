package com.seekerhub.seeker.controller;


import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.entity.Freelancer;
import com.seekerhub.seeker.service.user.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/freelancer")
public class FreelancerController {
    @Autowired
    private FreelancerService freelancerService;

    @PostMapping
    public ResponseEntity create(@RequestBody FreelancerDto freelancerDto) {
        return ResponseEntity.ok(freelancerService.save(freelancerDto));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(freelancerService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(freelancerService.findById(id));
    }


}
