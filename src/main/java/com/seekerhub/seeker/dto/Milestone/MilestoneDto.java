package com.seekerhub.seeker.dto.Milestone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MilestoneDto {

    private double amount;
    private String status;
    private LocalDateTime deadline;
    private String description;



}
