package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.user.UserForRegisterDto;
import com.seekerhub.seeker.entity.Employer;
import com.seekerhub.seeker.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployerMapper extends BaseMapper<Employer, EmployerDto> {


}
