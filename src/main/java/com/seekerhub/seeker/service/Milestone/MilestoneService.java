package com.seekerhub.seeker.service.Milestone;

import com.seekerhub.seeker.dto.Milestone.MilestoneDto;
import com.seekerhub.seeker.entity.Milestone;

import java.util.List;

public interface MilestoneService {

    MilestoneDto save(MilestoneDto milestoneDto);
    List<MilestoneDto> findAll();
    MilestoneDto findById(long id);
    void deleteById(long id);
    List<Milestone> findMilestoneBeforeByDeadline();
    MilestoneDto updateStatus(long id);



}
