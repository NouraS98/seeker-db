package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Milestone extends BaseEntity{

    private double amount;
    private String status;
    private LocalDateTime deadline;
    private String description;
    //projectId

}
