package com.seekerhub.seeker.dto.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBasicDto {
    private long id;
    private String title;
    private String description;
    private String category_type;
}
