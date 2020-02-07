package com.seekerhub.seeker.service.Project;

import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.entity.Freelancer;
import com.seekerhub.seeker.entity.Project;
import com.seekerhub.seeker.mapper.FreelancerMapper;
import com.seekerhub.seeker.mapper.ProjectMapper;
import com.seekerhub.seeker.repository.FreelancerRepository;
import com.seekerhub.seeker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public ProjectDto save(ProjectDto projectDto) {
        Project project = projectMapper.toEntity(projectDto);
        Project projectToSave = projectRepository.save(project);
        return projectMapper.toDto(projectToSave);
    }

    @Override
    public List<ProjectDto> findAll() {
        return projectMapper.toDtos(projectRepository.findAll());
    }

    @Override
    public ProjectDto findById(long id) {
        return projectMapper.toDto(projectRepository.getOne(id));
    }
}