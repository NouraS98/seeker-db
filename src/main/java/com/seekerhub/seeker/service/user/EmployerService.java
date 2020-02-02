package com.seekerhub.seeker.service.user;

import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.user.UserDto;

import java.util.List;

public interface EmployerService {
    EmployerDto save(EmployerDto employerDto);
    List<EmployerDto> findAll();
    EmployerDto findById(long id);

}
