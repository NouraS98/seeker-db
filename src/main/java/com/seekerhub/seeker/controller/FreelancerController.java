package com.seekerhub.seeker.controller;


import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.service.freelancer.FreelancerService;
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


    @GetMapping("user_id/{user_id}")
    public  ResponseEntity findByUserId(@PathVariable long user_id){
        return  ResponseEntity.ok(freelancerService.findByUserId(user_id));
    }
}
