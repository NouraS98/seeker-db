package com.seekerhub.seeker.mapper;


import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.dto.user.UserForRegisterDto;
import com.seekerhub.seeker.entity.Project;
import com.seekerhub.seeker.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends BaseMapper<Project, ProjectDto>{

}


