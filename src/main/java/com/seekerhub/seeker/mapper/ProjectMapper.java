package com.seekerhub.seeker.mapper;


import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends BaseMapper<Project, ProjectDto>{

}

