package com.seekerhub.seeker.entity;

import lombok.Data;
import org.springframework.data.annotation.*;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @SequenceGenerator(name="SequenceGenerator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SequenceGenerator")
    private Long id;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    private  String createdBy;

    @LastModifiedBy
    private String modifiedBy;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
