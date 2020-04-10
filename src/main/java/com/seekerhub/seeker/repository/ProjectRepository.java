package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.dto.Category.CategoryDto;
import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.entity.Category;
import com.seekerhub.seeker.entity.Employer;
import com.seekerhub.seeker.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    boolean existsByStatus(String status);
    List<Project> findByStatusAndEmployer(String status, Employer employer);
    //todo new 3 hind
    List<Project> findByStatus(String status);

    boolean existsByCategory(Category category);
    List<Project> findByCategory(Category category);

    @Query("SELECT p FROM Project p WHERE p.expiry_date between :from and :to and status = :status ")
    List<Project> findByExpiry_dateAndStatus(@Param("from") LocalDateTime fromDate, @Param("to") LocalDateTime toDate, @Param("status") String status);



}
