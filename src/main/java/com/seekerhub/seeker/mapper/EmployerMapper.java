package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.entity.Employer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployerMapper extends BaseMapper<Employer, EmployerDto> {
}
