package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Project extends BaseEntity {

    private String title;
    private String description;
    private double  budget;
    private String  type;
    private String  payment_type;
    private LocalDateTime expiry_date;
    private LocalDateTime deadline;

    @OneToMany(
            mappedBy = "project"
    )
    private List<Bid> bids = new ArrayList<>();

    @OneToMany(
            mappedBy = "project",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Milestone> milestones = new ArrayList<>();

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Employer employer;

   //employerId
    //categoryId
    public void addMilestone(Milestone milestone){
        milestones.add(milestone);
        milestone.setProject(this);

    }

    public void removeMilestone(Milestone milestone){
        milestones.remove(milestone);
        milestone.setProject(null);

    }

}
