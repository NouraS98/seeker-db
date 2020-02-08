package com.seekerhub.seeker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {
    private String title;
    private String description;


    @OneToMany(
            mappedBy = "category"
    )
    private List<Project> projects = new ArrayList<>();

    //categoryId

}


