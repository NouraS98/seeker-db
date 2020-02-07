package com.seekerhub.seeker.controller;


import com.seekerhub.seeker.dto.Milestone.MilestoneDto;
import com.seekerhub.seeker.dto.Skill.SkillDto;
import com.seekerhub.seeker.service.Milestone.MilestoneService;
import com.seekerhub.seeker.service.Skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/milestone")
public class MilestoneController {


    @Autowired
    private MilestoneService milestoneService;

    @PostMapping
    public ResponseEntity create(@RequestBody MilestoneDto milestoneDto) {
        return ResponseEntity.ok(milestoneService.save(milestoneDto));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(milestoneService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(milestoneService.findById(id));
    }




}
