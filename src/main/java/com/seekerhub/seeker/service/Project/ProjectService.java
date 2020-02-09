package com.seekerhub.seeker.service.Project;

import com.seekerhub.seeker.dto.Project.ProjectDto;

import java.util.List;

public interface ProjectService {
    ProjectDto save(ProjectDto projectDto);
    List<ProjectDto> findAll();
    ProjectDto findById(long id);
    void setStatus(long id);
}
