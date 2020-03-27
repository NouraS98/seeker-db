package com.seekerhub.seeker.service.employer;

import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.user.UserDto;

import java.util.List;

public interface EmployerService {
    EmployerDto save(EmployerDto employerDto);
    List<EmployerDto> findAll();
    EmployerDto findById(long id);
EmployerDto getByUserId(long user_id);

    //For rating
    List<Integer>  getEmployerRatingValues(long id);
    float getTotalEmployerRatings(long id);
    void setRatingValues(long id, int num_of_ratings, int response_time, int total_on_time_payment, float total_emp_ratings);

}
