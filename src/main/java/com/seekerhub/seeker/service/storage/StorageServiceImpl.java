package com.seekerhub.seeker.service.storage;

import com.seekerhub.seeker.dto.storageDocument.StorageDocumentDto;
import com.seekerhub.seeker.enums.StorageEnum;
import com.seekerhub.seeker.mapper.StorageMapper;
import com.seekerhub.seeker.repository.StorageDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired private StorageDocumentRepository storageDocumentRepository;
    @Autowired private StorageMapper storageMapper;

    @Override
    public List<StorageDocumentDto> findByType(StorageEnum type) {
        return storageMapper.toDtos(storageDocumentRepository.findByType(type));
    }
}
