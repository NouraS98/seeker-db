package com.seekerhub.seeker.service.storage;

import com.seekerhub.seeker.dto.storageDocument.StorageDocumentDto;
import com.seekerhub.seeker.enums.StorageEnum;

import java.util.List;

public interface StorageService {

    List<StorageDocumentDto> findByType(StorageEnum type);
}
