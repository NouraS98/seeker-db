package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.PurchaseOrder.PurchaseOrderDto;
import com.seekerhub.seeker.entity.PurchaseOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseOrderMapper extends BaseMapper<PurchaseOrder,PurchaseOrderDto> {

}
