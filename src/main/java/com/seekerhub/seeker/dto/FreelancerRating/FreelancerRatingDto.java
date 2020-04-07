package com.seekerhub.seeker.dto.FreelancerRating;

import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreelancerRatingDto {
    private long id;
    private int communication;
    private int professionalism;
    private int onTime;
    private int qualityOfWork;
    private int onBudget;
    private FreelancerDto freelancer;
    private EmployerDto employer;

}
