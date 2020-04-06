package com.seekerhub.seeker.controller;


import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.entity.Skill;
import com.seekerhub.seeker.service.freelancer.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/freelancer")
public class FreelancerController {
    @Autowired
    private FreelancerService freelancerService;

    @PostMapping
    public ResponseEntity create(@RequestBody FreelancerDto freelancerDto) {
        return ResponseEntity.ok(freelancerService.save(freelancerDto));
    }

    @GetMapping("findAll")
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



    //New by hind
    @PostMapping("maarof_account/{id}/{maarof_account}")
    public ResponseEntity setMaroof(@PathVariable long id, @PathVariable String maarof_account){
//        freelancerService.setMaroof(id,maarof_account);
        return ResponseEntity.ok(freelancerService.setMaroof(id,maarof_account));
    }

    @PostMapping("skills/{id}")
    public ResponseEntity setFreelancerSkills(@PathVariable long id, @RequestBody Set<Skill> skills){
       return ResponseEntity.ok(freelancerService.setSkills(id, skills)) ;
    }

    @GetMapping("get_maarof/{id}")
    public String getMaroof(@PathVariable long id){
        return freelancerService.getMaroof(id);
    }

    @PutMapping("rating_values")
    public void setFreelancerRatingValues(@RequestBody FreelancerDto freelancerDto){
        freelancerService.setRatingValues(freelancerDto.getId(),
                freelancerDto.getNum_of_ratings(),
                freelancerDto.getTotal_quality_of_work(),
                freelancerDto.getTotal_response_time()
               );
    }

    @PostMapping("hired_projs/{id}")
    public void setNumberOfWorkedOnProjects(@PathVariable long id){
        freelancerService.setNumberOfWorkedOnProjects(id);
    }

}
