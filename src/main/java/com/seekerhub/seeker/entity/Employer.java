package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employer extends BaseEntity {
    private int  num_of_ratings;
    private int  response_time;
    private int  num_of_posted_Projects;
    private int  total_on_time_payment;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(
            mappedBy = "employer"
    )
    private List<Project> projects = new ArrayList<>();

    @OneToOne(mappedBy = "employer")
    private Bid bid;
}
