package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.entity.Bid;
import com.seekerhub.seeker.entity.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
    boolean existsByStatus(String status);

    //todo 3 hind new
    //List<Project> findByStatus(String status);
    List<Bid> findBidByStatus(String status);
}