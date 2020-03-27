package com.seekerhub.seeker.controller;

import com.amazonaws.services.dynamodbv2.xspec.L;
import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.service.employer.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employer")
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @PostMapping
    public ResponseEntity create(@RequestBody EmployerDto employer) {
        return ResponseEntity.ok(employerService.save(employer));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(employerService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(employerService.findById(id));
    }
    @GetMapping("user_id/{user_id}")
    public ResponseEntity getByUserId(@PathVariable long user_id) {
        return ResponseEntity.ok(employerService.getByUserId(user_id));
    }

    //Rating related methods

    @GetMapping("get_rating_values/{id}")
    public List<Integer> getEmployerRatingValues(@PathVariable long id){
        return employerService.getEmployerRatingValues(id);
    }

    @GetMapping("get_total_emp_rating/{id}")
    public float getTotalRating(@PathVariable long id){
        return employerService.getTotalEmployerRatings(id);
    }

    @PostMapping("set_rating_values/{id}")
    public void setEmployerRatingValues(@PathVariable long id, @PathVariable int num_of_ratings, @PathVariable int response_time, @PathVariable int total_on_time_payment, @PathVariable float total_emp_ratings){

        employerService.setRatingValues(id, num_of_ratings, response_time, total_on_time_payment, total_emp_ratings);

    }




}
