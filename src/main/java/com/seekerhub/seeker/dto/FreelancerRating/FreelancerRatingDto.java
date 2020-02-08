package com.seekerhub.seeker.dto.FreelancerRating;

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

}
