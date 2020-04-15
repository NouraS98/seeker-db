package com.seekerhub.seeker.dto.Freelancer;

import com.seekerhub.seeker.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreelancerBasicDto {
    private long id;
    private UserDto user;

}
