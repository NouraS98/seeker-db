package com.seekerhub.seeker.service.EmployerRating;

import com.seekerhub.seeker.dto.EmployerRating.EmployerRatingDto;
import com.seekerhub.seeker.dto.Milestone.MilestoneDto;
import com.seekerhub.seeker.entity.EmployerRating;
import com.seekerhub.seeker.entity.Milestone;
import com.seekerhub.seeker.mapper.EmployerMapper;
import com.seekerhub.seeker.mapper.EmployerRatingMapper;
import com.seekerhub.seeker.mapper.MilestoneMapper;
import com.seekerhub.seeker.repository.EmployerRatingRepository;
import com.seekerhub.seeker.repository.MilestoneRepository;
import com.seekerhub.seeker.service.Milestone.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerRatingServiceImp implements EmployerRatingService {
    @Autowired
    EmployerRatingRepository employerRatingRepository;
    @Autowired
    EmployerRatingMapper employerRatingMapper;

    @Override
    public EmployerRatingDto save(EmployerRatingDto employerRatingDto) {
        EmployerRating employerRating = employerRatingMapper.toEntity(employerRatingDto);
        EmployerRating employerRatingToSave = employerRatingRepository.save(employerRating);
        return employerRatingMapper.toDto(employerRatingToSave);
    }

    @Override
    public List<EmployerRatingDto> findAll() {
        return employerRatingMapper.toDtos(employerRatingRepository.findAll());
    }

    @Override
    public EmployerRatingDto findById(long id) {
        return employerRatingMapper.toDto(employerRatingRepository.getOne(id));
    }


}
