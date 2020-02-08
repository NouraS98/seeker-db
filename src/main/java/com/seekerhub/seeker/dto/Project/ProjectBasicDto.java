package com.seekerhub.seeker.dto.Project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectBasicDto {
    private long id;
    private String title;
    private String description;
}
