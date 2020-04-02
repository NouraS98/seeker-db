package com.seekerhub.seeker.controller;


import com.seekerhub.seeker.dto.FreelancerRating.FreelancerRatingDto;
import com.seekerhub.seeker.dto.Skill.SkillDto;
import com.seekerhub.seeker.service.FreelancerRating.FreelancerRatingService;
import com.seekerhub.seeker.service.Skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/freelancerRating")
public class FreelancerRatingController {


    @Autowired
    private FreelancerRatingService freelancerRatingService;

    @PostMapping("add")
    public ResponseEntity create(@RequestBody FreelancerRatingDto freelancerRatingDto) {
        return ResponseEntity.ok(freelancerRatingService.save(freelancerRatingDto));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(freelancerRatingService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(freelancerRatingService.findById(id));
    }




}
