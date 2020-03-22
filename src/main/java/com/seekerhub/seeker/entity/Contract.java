package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Contract extends BaseEntity{
    private double price;
    private LocalDateTime deadline;
    private String type;

    @OneToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    private Freelancer freelancer;

//bidId
    //employerId
}
