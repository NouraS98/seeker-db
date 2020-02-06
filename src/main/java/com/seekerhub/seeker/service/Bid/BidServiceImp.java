package com.seekerhub.seeker.service.Bid;

import com.seekerhub.seeker.dto.Bid.BidDto;
import com.seekerhub.seeker.entity.Bid;
import com.seekerhub.seeker.mapper.BidMapper;
import com.seekerhub.seeker.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImp implements BidService {
    @Autowired
    BidRepository bidRepository;
    @Autowired
    BidMapper bidMapper;

    @Override
    public BidDto save(BidDto bidDto) {
        Bid bid = bidMapper.toEntity(bidDto);
        Bid bidToSave = bidRepository.save(bid);
        return bidMapper.toDto(bidToSave);
    }

    @Override
    public List<BidDto> findAll() {
        return bidMapper.toDtos(bidRepository.findAll());
    }

    @Override
    public BidDto findById(long id) {
        return bidMapper.toDto(bidRepository.getOne(id));
    }


}
