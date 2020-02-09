package com.seekerhub.seeker.dto.Category;

import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.dto.Skill.SkillDto;
import com.seekerhub.seeker.entity.Category;
import com.seekerhub.seeker.entity.Project;
import com.seekerhub.seeker.entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private long id;
    private String title;
    private String description;
    private List<ProjectDto> projects = new ArrayList<>();
    private Set<SkillDto> skills = new HashSet<>();


}
