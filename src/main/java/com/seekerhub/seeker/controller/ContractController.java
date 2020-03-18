package com.seekerhub.seeker.controller;

import com.seekerhub.seeker.dto.Chat.ChatDto;
import com.seekerhub.seeker.dto.Contract.ContractDto;
import com.seekerhub.seeker.service.Chat.ChatService;
import com.seekerhub.seeker.service.Contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @PostMapping
    public ResponseEntity create(@RequestBody ContractDto contractDto) {
        return ResponseEntity.ok(contractService.save(contractDto));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(contractService.findAll());
    }

    @GetMapping("project_id/{project_id}")
    public ResponseEntity findByProjectId(@PathVariable long project_id){
        return ResponseEntity.ok(contractService.findByProjectId(project_id));
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(contractService.findById(id));
    }

}
