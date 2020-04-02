package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerRating extends BaseEntity{
    //to use
    private int communication;
    private int professionalism;
    private int onTimePayment;

    @OneToOne
    @JoinColumn(name = "freelancer_id", referencedColumnName = "id")
    private Freelancer freelancer;

    @OneToOne
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private Employer employer;


//freelancerId
    //employerId
}
