package com.seekerhub.seeker.service.freelancer;

import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;

import java.util.List;

public interface FreelancerService {
    FreelancerDto save(FreelancerDto freelancerDto);
    List<FreelancerDto> findAll();
    FreelancerDto findById(long id);
    FreelancerDto findByUserId(long user_id);
}
