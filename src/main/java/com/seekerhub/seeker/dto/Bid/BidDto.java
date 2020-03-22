package com.seekerhub.seeker.dto.Bid;

import com.seekerhub.seeker.dto.Contract.ContractDto;
import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Freelancer.FreelancerBasicDto;
import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.dto.Project.ProjectBasicDto;
import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.entity.Bid;
import com.seekerhub.seeker.entity.Employer;
import com.seekerhub.seeker.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidDto {
    private long id;
    private String title;
    private String description;
    private double  price;
    private LocalDateTime deliver_date;
    private String  status;
    private ProjectBasicDto project;
    private FreelancerBasicDto freelancer;
//    private ContractDto contract;
}
