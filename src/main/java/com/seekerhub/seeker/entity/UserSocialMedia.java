package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserSocialMedia extends BaseEntity{

    @ColumnDefault("N/A")
    private String twitter;

    @ColumnDefault("N/A")
    private String facebook;

    @ColumnDefault("N/A")
    private String linkedIn;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;



}
//weak entity