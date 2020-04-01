package com.seekerhub.seeker.service.freelancer;

import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.entity.Skill;

import java.util.List;
import java.util.Set;

public interface FreelancerService {
    FreelancerDto save(FreelancerDto freelancerDto);
    List<FreelancerDto> findAll();
    FreelancerDto findById(long id);
    FreelancerDto findByUserId(long user_id);
    void setMaroof(long id, String maarof_account);
    FreelancerDto setSkills(long id, Set<Skill> skills);

    String getMaroof(long id);
}
