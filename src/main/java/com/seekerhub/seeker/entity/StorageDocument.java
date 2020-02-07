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

    private String key;

    private String name;

    @Enumerated(EnumType.STRING)
    private StorageEnum type;

    private String url;

    private String contentType;

}
