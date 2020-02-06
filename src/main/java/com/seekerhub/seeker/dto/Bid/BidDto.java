package com.seekerhub.seeker.dto.Bid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidDto {

    private String title;
    private String description;
    private double  price;
    private LocalDateTime deliver_date;
    private String  status;

}
