package com.seekerhub.seeker.service.freelancer;

import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.entity.Freelancer;

import java.util.List;

public interface FreelancerService {
    FreelancerDto save(FreelancerDto freelancerDto);
    List<FreelancerDto> findAll();
    FreelancerDto findById(long id);
}
