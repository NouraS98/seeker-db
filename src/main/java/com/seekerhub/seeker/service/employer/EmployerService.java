package com.seekerhub.seeker.service.employer;

import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.user.UserDto;

import java.util.List;

public interface EmployerService {
    EmployerDto save(EmployerDto employerDto);
    List<EmployerDto> findAll();
    EmployerDto findById(long id);
EmployerDto getByUserId(long user_id);

}
