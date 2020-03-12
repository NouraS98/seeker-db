package com.seekerhub.seeker.controller;

import com.seekerhub.seeker.dto.Category.CategoryDto;
import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.entity.Employer;
import com.seekerhub.seeker.service.Project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
    @RequestMapping("api/project")
    public class ProjectController {
        @Autowired
        private ProjectService projectService;

        @PostMapping("post")
        public ResponseEntity create(@RequestBody ProjectDto projectDto) {
            return ResponseEntity.ok(projectService.save(projectDto));
        }

        @PostMapping("with-attachments")
        public ResponseEntity create(@RequestPart("project") ProjectDto projectDto, @RequestPart("attachments") List<MultipartFile> attachments) {
            return ResponseEntity.ok(projectService.saveWithAttachments(projectDto, attachments));
        }

        @GetMapping ("findAll")
        public ResponseEntity findAll() {
            return ResponseEntity.ok(projectService.findAll());
        }

        @PostMapping("status/{status}")
        public ResponseEntity findByStatusAndEmployer(@PathVariable String status, @RequestBody EmployerDto employer){
            return ResponseEntity.ok(projectService.findByStatusAndEmployer(status,employer));
        }

        //todo new 4 hind

    @PostMapping("statuses/{status}")
    public ResponseEntity findByStatus(@PathVariable String status){
            return ResponseEntity.ok(projectService.findByStatus(status));
    }

        @GetMapping("{id}")
        public ResponseEntity findById(@PathVariable long id) {
            return ResponseEntity.ok(projectService.findById(id));
        }

        @PostMapping("{id}/add-attachment")
        public ResponseEntity addAttachment(@PathVariable long id, @RequestPart("attachment") MultipartFile attachment) {
            return ResponseEntity.ok(projectService.addAttachment(id, attachment));
        }

        @DeleteMapping("{id}/delete-attachment/{attachmentId}")
        public void deleteAttachmentById(@PathVariable long id, @PathVariable long attachmentId){
            projectService.deleteAttachmentById(id, attachmentId);
        }



    @PostMapping("category")
    public ResponseEntity findProjectByCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(projectService.findByCategory(categoryDto));
    }



    }
