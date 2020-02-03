package com.seekerhub.seeker.service.user;

import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.entity.Employer;
import com.seekerhub.seeker.entity.Freelancer;
import com.seekerhub.seeker.mapper.EmployerMapper;
import com.seekerhub.seeker.mapper.FreelancerMapper;
import com.seekerhub.seeker.repository.EmployerRepository;
import com.seekerhub.seeker.repository.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreelancerServiceImp implements FreelancerService {
    @Autowired
    FreelancerRepository freelancerRepository;

    @Autowired
    FreelancerMapper freelancerMapper;

    @Override
    public FreelancerDto save(FreelancerDto freelancerDto) {
        Freelancer freelancer = freelancerMapper.toEntity(freelancerDto);
        Freelancer freelancerToSave = freelancerRepository.save(freelancer);
        return freelancerMapper.toDto(freelancerToSave);
    }

    @Override
    public List<FreelancerDto> findAll() {
        return freelancerMapper.toDtos(freelancerRepository.findAll());
    }

    @Override
    public FreelancerDto findById(long id) {
        return freelancerMapper.toDto(freelancerRepository.getOne(id));
    }
}
