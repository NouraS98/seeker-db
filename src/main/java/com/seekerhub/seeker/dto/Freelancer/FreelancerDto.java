package com.seekerhub.seeker.dto.Freelancer;

import com.seekerhub.seeker.dto.Bid.BidDto;
import com.seekerhub.seeker.dto.Skill.SkillDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.entity.Employer;
import com.seekerhub.seeker.entity.Freelancer;
import com.seekerhub.seeker.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreelancerDto {
    private long id;
    private UserDto user;
    private String maarof_account;
    private int num_of_ratings;
    private int total_response_time;
    private int total_quality_of_work;
    private int num_of_hired_projects;
    private List<BidDto> bids = new ArrayList<>();
    private String fullName;
    private String ibanNumber;
  //  private Employer employer;
    //todo new - just added 14 march
  private Set<SkillDto> skills = new HashSet<>();
    private double credit;

}
