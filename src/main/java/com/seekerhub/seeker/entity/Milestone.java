package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Milestone extends BaseEntity{

    private double amount;
    private String status;
    private LocalDateTime deadline;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "project_id", referencedColumnName ="id")
    private Project project;

}
