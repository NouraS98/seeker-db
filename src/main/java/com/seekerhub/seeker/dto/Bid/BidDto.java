package com.seekerhub.seeker.dto.Bid;

import com.seekerhub.seeker.dto.Project.ProjectBasicDto;
import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidDto {
    private long id;
    private String title;
    private String description;
    private double  price;
    private LocalDateTime deliver_date;

    private String  status;
    private ProjectBasicDto project;

}
