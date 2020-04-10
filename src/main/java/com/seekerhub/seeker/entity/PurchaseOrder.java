package com.seekerhub.seeker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder extends BaseEntity {
    private String orderNumber;
    private String transactionId;
    private double amount;

    @OneToOne
    @JoinColumn(name = "milestone_id" ,referencedColumnName = "id")
    Milestone milestone;

}
