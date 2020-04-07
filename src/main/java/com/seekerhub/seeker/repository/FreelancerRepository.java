package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.entity.Freelancer;
import com.seekerhub.seeker.entity.Skill;
import com.seekerhub.seeker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer,Long> {
    Freelancer findByUserId(Long user_id);

    @Query("SELECT f from Freelancer f inner join fetch f.skills s WHERE s.id in :id")
    List<Freelancer> findBySkillIn(@Param("id") Collection<Long> id);

    List<Freelancer> findAllBySkillsIdIn(Collection<Long> id);
}
