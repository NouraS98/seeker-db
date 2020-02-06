package com.seekerhub.seeker.controller;

import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.service.Project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



    @RestController
    @RequestMapping("api/project")
    public class ProjectController {
        @Autowired
        private ProjectService projectService;

        @PostMapping
        public ResponseEntity create(@RequestBody ProjectDto projectDto) {
            return ResponseEntity.ok(projectService.save(projectDto));
        }

        @GetMapping
        public ResponseEntity findAll() {
            return ResponseEntity.ok(projectService.findAll());
        }

        @GetMapping("{id}")
        public ResponseEntity findById(@PathVariable long id) {
            return ResponseEntity.ok(projectService.findById(id));
        }

    }
