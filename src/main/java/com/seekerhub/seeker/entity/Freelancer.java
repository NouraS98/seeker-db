package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Freelancer extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private String maarof_account;
    private int num_of_ratings;
    private int total_response_time;
    private int total_quality_of_work;
    private int num_of_hired_projects;

    @OneToMany(
            mappedBy = "freelancer",
            fetch = FetchType.LAZY

    )
    private List<Bid> bids = new ArrayList<>();


}
