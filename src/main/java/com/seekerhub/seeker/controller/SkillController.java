package com.seekerhub.seeker.controller;


import com.seekerhub.seeker.dto.Bid.BidDto;
import com.seekerhub.seeker.dto.Skill.SkillDto;
import com.seekerhub.seeker.service.Bid.BidService;
import com.seekerhub.seeker.service.Skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/skill")
public class SkillController {


    @Autowired
    private SkillService skillService;

    @PostMapping
    public ResponseEntity create(@RequestBody SkillDto skillDto) {
        return ResponseEntity.ok(skillService.save(skillDto));
    }

    @GetMapping("find-all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(skillService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(skillService.findById(id));
    }




}
