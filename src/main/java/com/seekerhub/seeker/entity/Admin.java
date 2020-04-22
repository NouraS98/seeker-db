package com.seekerhub.seeker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {

    @Id
    @Column(unique = true)
    private long id;
    @Column(unique = true , nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true , nullable = false)
    private String email;

}
