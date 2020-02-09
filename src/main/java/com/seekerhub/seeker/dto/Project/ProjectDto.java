package com.seekerhub.seeker.dto.Project;

import com.seekerhub.seeker.dto.Bid.BidDto;
import com.seekerhub.seeker.dto.Category.CategoryBasicDto;
import com.seekerhub.seeker.dto.Category.CategoryDto;
import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Milestone.MilestoneDto;
import com.seekerhub.seeker.dto.Skill.SkillDto;
import com.seekerhub.seeker.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<SkillDto> skills = new HashSet<>();
    private CategoryBasicDto category;
    private String status;




}
