package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.EmployerRating.EmployerRatingDto;
import com.seekerhub.seeker.entity.EmployerRating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployerRatingMapper extends BaseMapper<EmployerRating, EmployerRatingDto>{
}
