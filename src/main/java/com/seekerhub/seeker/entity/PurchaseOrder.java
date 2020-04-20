package com.seekerhub.seeker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

import static javax.persistence.CascadeType.REMOVE;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder extends BaseEntity {
    private String orderNumber;
    private String transactionId;
    private double amount;

    @OneToOne(fetch = FetchType.LAZY, cascade = REMOVE)
    @JoinColumn(name = "milestone_id" ,referencedColumnName = "id")
    Milestone milestone;

}
