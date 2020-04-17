package com.seekerhub.seeker.dto.Project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.seekerhub.seeker.dto.Bid.BidDto;
import com.seekerhub.seeker.dto.Category.CategoryBasicDto;
import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Milestone.MilestoneDto;
import com.seekerhub.seeker.dto.Skill.SkillDto;
import com.seekerhub.seeker.dto.storageDocument.StorageDocumentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

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
    //0 pending , //1 on progress, //2 completed
    private String status;
    private LocalDateTime createdAt;
    private List<StorageDocumentDto> attachments = new ArrayList<>();

    private boolean did_emp_rate;
    private boolean did_fr_rate;


}
