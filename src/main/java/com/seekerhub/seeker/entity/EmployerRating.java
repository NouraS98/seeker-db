package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployerRating extends BaseEntity{
    //to use
    private int communication;
    private int professionalism;
    private int onTimePayment;
//freelancerId
    //employerId
}
