package com.seekerhub.seeker.dto.Employer;

import com.seekerhub.seeker.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDto {
    private long id;
    private int  num_of_ratings;
    private int  response_time;
    private int  num_of_posted_Projects;
    private int  total_on_time_payment;
    private UserDto user;

}
