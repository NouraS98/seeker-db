package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
public class Certificate extends BaseEntity{

    //todo hind newest
    private String certificates;
//freelancerId
}
//I have removed the @NoArgsConstructor
//@AllArgsConstructor annotation