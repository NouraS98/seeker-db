package com.seekerhub.seeker.dto.EmployerRating;

import com.seekerhub.seeker.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployerRatingDto {

    private int communication;
    private int professionalism;
    private int onTimePayment;

}
