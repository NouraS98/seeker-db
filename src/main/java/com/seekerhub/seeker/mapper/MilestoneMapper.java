package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.Milestone.MilestoneDto;
import com.seekerhub.seeker.entity.Milestone;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MilestoneMapper extends BaseMapper<Milestone, MilestoneDto>{

}