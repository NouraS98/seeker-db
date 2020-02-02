package com.seekerhub.seeker.service.user;

import com.seekerhub.seeker.dto.Employer.EmployerDto;

import com.seekerhub.seeker.entity.Employer;
import com.seekerhub.seeker.mapper.EmployerMapper;
import com.seekerhub.seeker.repository.EmployerRepository;
import com.seekerhub.seeker.service.user.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImp implements EmployerService {
    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    EmployerMapper employerMapper;

    @Override
    public EmployerDto save(EmployerDto employerDto) {
        Employer employer = employerMapper.toEntity(employerDto);
        Employer employerToSave = employerRepository.save(employer);
        return employerMapper.toDto(employerToSave);
    }

    @Override
    public List<EmployerDto> findAll() {
        return employerMapper.toDtos(employerRepository.findAll());
    }

    @Override
    public EmployerDto findById(long id) {
        return employerMapper.toDto(employerRepository.getOne(id));
    }
}
