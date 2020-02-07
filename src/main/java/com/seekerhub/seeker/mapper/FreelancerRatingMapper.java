package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.FreelancerRating.FreelancerRatingDto;
import com.seekerhub.seeker.entity.FreelancerRating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FreelancerRatingMapper extends BaseMapper<FreelancerRating, FreelancerRatingDto>{
}
