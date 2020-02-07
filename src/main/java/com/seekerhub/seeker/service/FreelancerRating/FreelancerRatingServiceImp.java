package com.seekerhub.seeker.service.FreelancerRating;

import com.seekerhub.seeker.dto.FreelancerRating.FreelancerRatingDto;

import com.seekerhub.seeker.entity.FreelancerRating;
import com.seekerhub.seeker.mapper.FreelancerRatingMapper;
import com.seekerhub.seeker.repository.FreelancerRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreelancerRatingServiceImp implements FreelancerRatingService {
    @Autowired
    FreelancerRatingRepository freelancerRatingRepository;
    @Autowired
    FreelancerRatingMapper freelancerRatingMapper;

    @Override
    public FreelancerRatingDto save(FreelancerRatingDto freelancerRatingDto) {
        FreelancerRating freelancerRating = freelancerRatingMapper.toEntity(freelancerRatingDto);
        FreelancerRating freelancerRatingToSave = freelancerRatingRepository.save(freelancerRating);
        return freelancerRatingMapper.toDto(freelancerRatingToSave);
    }

    @Override
    public List<FreelancerRatingDto> findAll() {
        return freelancerRatingMapper.toDtos(freelancerRatingRepository.findAll());
    }

    @Override
    public FreelancerRatingDto findById(long id) {
        return freelancerRatingMapper.toDto(freelancerRatingRepository.getOne(id));
    }


}
