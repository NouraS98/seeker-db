package com.seekerhub.seeker.service.Bid;

import com.seekerhub.seeker.dto.Bid.BidDto;
import com.seekerhub.seeker.dto.Project.ProjectDto;

import java.util.List;

public interface BidService {

    BidDto save(BidDto bidDto);
    List<BidDto> findAll();
    BidDto findById(long id);
    void acceptBid(long id);

}
