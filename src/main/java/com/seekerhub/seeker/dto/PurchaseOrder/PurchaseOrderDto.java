package com.seekerhub.seeker.dto.PurchaseOrder;

import com.seekerhub.seeker.dto.Milestone.MilestoneDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDto {
    private Long id;
    private String orderNumber;
    private String transactionId;
    private double amount;
    MilestoneDto milestone;

}