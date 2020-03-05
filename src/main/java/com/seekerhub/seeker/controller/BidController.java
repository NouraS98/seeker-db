package com.seekerhub.seeker.controller;


import com.seekerhub.seeker.dto.Bid.BidDto;
import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.entity.Freelancer;
import com.seekerhub.seeker.service.Bid.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bid")
public class BidController {


    @Autowired
    private BidService bidService;

    @PostMapping("post")
    public ResponseEntity create(@RequestBody BidDto bidDto) {
        return ResponseEntity.ok(bidService.save(bidDto));
    }

    @GetMapping("find-all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(bidService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return ResponseEntity.ok(bidService.findById(id));
    }

    @PutMapping("accept-bid/{id}")
    public ResponseEntity AcceptBid(@PathVariable long id){
        return ResponseEntity.ok(bidService.acceptBid(id));
    }


}
