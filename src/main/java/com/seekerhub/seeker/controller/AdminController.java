package com.seekerhub.seeker.controller;


import com.seekerhub.seeker.dto.Admin.AdminDto;
import com.seekerhub.seeker.dto.Skill.SkillDto;
import com.seekerhub.seeker.service.Admin.AdminService;
import com.seekerhub.seeker.service.Skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
public class AdminController {


    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity create(@RequestBody AdminDto adminDto) {
        return ResponseEntity.ok(adminService.save(adminDto));
    }

    @GetMapping("find-all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(adminService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(adminService.findById(id));
    }




}
