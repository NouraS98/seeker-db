package com.seekerhub.seeker.service.EmployerRating;

import com.seekerhub.seeker.dto.EmployerRating.EmployerRatingDto;

import java.util.List;

public interface EmployerRatingService {

    EmployerRatingDto save(EmployerRatingDto employerRatingDto);
    List<EmployerRatingDto> findAll();
    EmployerRatingDto findById(long id);

}
