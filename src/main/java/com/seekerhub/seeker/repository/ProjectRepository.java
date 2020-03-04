package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.entity.Employer;
import com.seekerhub.seeker.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    boolean existsByStatus(String status);
    List<Project> findByStatusAndEmployer(String status, Employer employer);

}
