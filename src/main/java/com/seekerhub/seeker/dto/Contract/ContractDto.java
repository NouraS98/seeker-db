package com.seekerhub.seeker.dto.Contract;

import com.seekerhub.seeker.dto.Bid.BidDto;
import com.seekerhub.seeker.dto.user.UserDto;
import com.seekerhub.seeker.entity.Bid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto {
    private long id;
    private double price;
    private LocalDateTime deadline;
    private String type;

}
