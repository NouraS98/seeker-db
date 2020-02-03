package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.entity.Freelancer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FreelancerMapper extends BaseMapper<Freelancer, FreelancerDto>{
}
