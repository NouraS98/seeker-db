package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.entity.Contract;
import com.seekerhub.seeker.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    Contract findByProjectId(long project_id);

    @Query("SELECT c.project from Contract c where c.project.status = '1' and c.freelancer.id = :id ")
    List<Project> findByFreelanerId(@Param("id") Long freelancer_id);



}