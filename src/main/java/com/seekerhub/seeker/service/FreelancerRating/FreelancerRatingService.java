package com.seekerhub.seeker.service.FreelancerRating;

import com.seekerhub.seeker.dto.EmployerRating.EmployerRatingDto;
import com.seekerhub.seeker.dto.FreelancerRating.FreelancerRatingDto;

import java.util.List;

public interface FreelancerRatingService {

    FreelancerRatingDto save(FreelancerRatingDto freelancerRatingDto);
    List<FreelancerRatingDto> findAll();
    FreelancerRatingDto findById(long id);

}
