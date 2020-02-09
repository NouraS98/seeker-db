package com.seekerhub.seeker.dto.Employer;

import com.seekerhub.seeker.dto.Bid.BidDto;
import com.seekerhub.seeker.dto.Project.ProjectBasicDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.entity.Bid;
import com.seekerhub.seeker.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    // حطيت بيسك مو البروجكت العادية عشان مايسوي لوب ومب لازم دايم احط كذا
    private List<ProjectBasicDto> projects = new ArrayList<>();

}
