package com.seekerhub.seeker.entity;

import com.seekerhub.seeker.enums.StorageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StorageDocument extends BaseEntity {

    // Id for DigitalOcean
    private String key;

    // Name of document
    private String name;

    // Type of document
    @Enumerated(EnumType.STRING)
    private StorageEnum type;

    private String url;

    private String contentType;

}
