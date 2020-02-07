package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.entity.FreelancerRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreelancerRatingRepository extends JpaRepository<FreelancerRating, Long> {
}
