package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Employer employer;

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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "skill_category" , joinColumns = { // هنا اسوي جوين لل٢ تيبلز عشان العلاقة ماني تو ماني
            @JoinColumn(name = "project_id" , referencedColumnName = "id") // التيبل الاول
    }, inverseJoinColumns = {
            @JoinColumn(name = "skill_name" , referencedColumnName = "name") // التيبل الثاني
    })
    private Set<Skill> skills = new HashSet<>();

    @ManyToOne
    private Category category;

}
