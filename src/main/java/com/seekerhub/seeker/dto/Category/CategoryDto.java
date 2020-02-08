package com.seekerhub.seeker.dto.Category;

import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.entity.Category;
import com.seekerhub.seeker.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private long id;
    private String title;
    private String description;
    private List<ProjectDto> projects = new ArrayList<>();

}
