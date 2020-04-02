package com.seekerhub.seeker.dto.EmployerRating;

import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.entity.Employer;
import com.seekerhub.seeker.entity.Freelancer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployerRatingDto {
    private long id;
    private int communication;
    private int professionalism;
    private int onTimePayment;
    private FreelancerDto freelancer;
    private EmployerDto employer;

}
