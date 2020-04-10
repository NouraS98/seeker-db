package com.seekerhub.seeker.controller;


import com.seekerhub.seeker.dto.PurchaseOrder.PurchaseOrderDto;
import com.seekerhub.seeker.mapper.PurchaseOrderMapper;
import com.seekerhub.seeker.service.PurchaseOrder.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class PurchaseOrderController {
    @Autowired
    PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity save(@RequestBody  PurchaseOrderDto purchaseOrderDto){
        return ResponseEntity.ok(purchaseOrderService.save(purchaseOrderDto));
    }

}
