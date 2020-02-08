package com.seekerhub.seeker.dto.Project;

import com.seekerhub.seeker.dto.Bid.BidDto;
import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Milestone.MilestoneDto;
import com.seekerhub.seeker.entity.Bid;
import com.seekerhub.seeker.entity.Employer;
import com.seekerhub.seeker.entity.Milestone;
import com.seekerhub.seeker.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private long id;
    private String title;
    private String description;
    private double  budget;
    private String  type;
    private String  payment_type;
    private LocalDateTime expiry_date;
    private LocalDateTime deadline;
    private List<BidDto> bids = new ArrayList<>();
    private EmployerDto employer;
    private List<MilestoneDto> milestones = new ArrayList<>();




}
