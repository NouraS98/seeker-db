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
public class Bid extends BaseEntity{
    private String title;
    private String description;
    private double  price;
    private LocalDateTime deliver_date;
    private String  status;

//projectId
    //freelancerId
}
