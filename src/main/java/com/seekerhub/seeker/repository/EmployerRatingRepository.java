package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.entity.EmployerRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRatingRepository extends JpaRepository<EmployerRating, Long> {
}
