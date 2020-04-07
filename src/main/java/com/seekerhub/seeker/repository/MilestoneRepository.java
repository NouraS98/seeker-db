package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.entity.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {

    @Query("SELECT m FROM Milestone m WHERE m.deadline between :from and :to and status = :status ")
    List<Milestone> findByDeadlineAndStatus(@Param("from") LocalDateTime startOfDay, @Param("to") LocalDateTime endOfDay, @Param("status") String s);
}