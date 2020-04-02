package com.seekerhub.seeker.controller;


import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.EmployerRating.EmployerRatingDto;
import com.seekerhub.seeker.dto.FreelancerRating.FreelancerRatingDto;
import com.seekerhub.seeker.entity.Employer;
import com.seekerhub.seeker.service.EmployerRating.EmployerRatingService;
import com.seekerhub.seeker.service.FreelancerRating.FreelancerRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employerRating")
public class EmployerRatingController {


    @Autowired
    private EmployerRatingService employerRatingService;

    @PostMapping("add")
    public ResponseEntity create(@RequestBody EmployerRatingDto employerRatingDto) {
        return ResponseEntity.ok(employerRatingService.save(employerRatingDto));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(employerRatingService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(employerRatingService.findById(id));
    }

    @PostMapping("emp")
    public double calcEmpRatings(@RequestBody Employer employer_id){
        return employerRatingService.calculateTotalRatings(employer_id.getId());
    }




}
