package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.entity.Freelancer;
import com.seekerhub.seeker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer,Long> {
    Freelancer findByUserId(Long user_id);

}
