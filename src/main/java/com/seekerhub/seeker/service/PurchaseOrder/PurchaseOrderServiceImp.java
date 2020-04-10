package com.seekerhub.seeker.service.PurchaseOrder;

import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.dto.PurchaseOrder.PurchaseOrderDto;
import com.seekerhub.seeker.entity.Project;
import com.seekerhub.seeker.entity.PurchaseOrder;
import com.seekerhub.seeker.mapper.PurchaseOrderMapper;
import com.seekerhub.seeker.repository.PurchaseOrderRepository;
import com.seekerhub.seeker.service.Milestone.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PurchaseOrderServiceImp implements PurchaseOrderService {

    @Autowired
    PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    MilestoneService milestoneService;

    @Override
    public PurchaseOrderDto save(PurchaseOrderDto purchaseOrderDto) {


            PurchaseOrder purchaseOrder = purchaseOrderMapper.toEntity(purchaseOrderDto);
            //TODO:
         milestoneService.updateStatus(purchaseOrder.getMilestone().getId());
            return purchaseOrderMapper.toDto(purchaseOrderRepository.save(purchaseOrder));

    }
}
