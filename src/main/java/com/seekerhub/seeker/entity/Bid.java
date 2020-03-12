package com.seekerhub.seeker.entity;

import com.seekerhub.seeker.dto.Employer.EmployerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
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

    @ColumnDefault("0")
    private String  status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    private Freelancer freelancer;


    @OneToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

//projectId
    //freelancerId
}
