package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.entity.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer,Long> {

}
