package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.Bid.BidDto;
import com.seekerhub.seeker.entity.Bid;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface BidMapper extends BaseMapper<Bid, BidDto>{

}