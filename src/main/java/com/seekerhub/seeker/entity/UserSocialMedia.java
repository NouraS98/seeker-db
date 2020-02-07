package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserSocialMedia extends BaseEntity{
    private String twitter;
    private String facebook;
    private String linkedIn;


}
//weak entity