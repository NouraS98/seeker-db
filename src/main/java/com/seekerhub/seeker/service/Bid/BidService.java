package com.seekerhub.seeker.service.Bid;

import com.seekerhub.seeker.dto.Bid.BidDto;
import com.seekerhub.seeker.dto.Contract.ContractDto;
import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.entity.Bid;
import com.seekerhub.seeker.entity.Freelancer;

import java.util.List;

public interface BidService {

    BidDto save(BidDto bidDto);
    List<BidDto> findAll();
    BidDto findById(long id);
    ContractDto acceptBid(long id);
    //todo new hind 1
    List<BidDto> findBidByStatus(String status);

    void deleteBidById(long id);

    void deleteBidByIdAdmin(long id);

}
