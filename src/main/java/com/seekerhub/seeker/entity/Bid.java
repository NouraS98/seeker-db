package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
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
    @Column(columnDefinition = "text default pending")
    private String  status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

//projectId
    //freelancerId
}
