package com.seekerhub.seeker.dto.storageDocument;

import com.seekerhub.seeker.enums.StorageEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorageDocumentDto implements Serializable {
    private String name;
    private StorageEnum type;
    private String url;
    private String contentType;
}
