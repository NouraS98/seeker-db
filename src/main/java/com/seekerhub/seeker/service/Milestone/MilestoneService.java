package com.seekerhub.seeker.service.Milestone;

import com.seekerhub.seeker.dto.Milestone.MilestoneDto;

import java.util.List;

public interface MilestoneService {

    MilestoneDto save(MilestoneDto milestoneDto);
    List<MilestoneDto> findAll();
    MilestoneDto findById(long id);

}