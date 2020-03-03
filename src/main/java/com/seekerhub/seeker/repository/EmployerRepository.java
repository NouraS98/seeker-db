package com.seekerhub.seeker.repository;

import com.amazonaws.services.dynamodbv2.xspec.L;
import com.seekerhub.seeker.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
Employer getByUserId(long user_id);

}

