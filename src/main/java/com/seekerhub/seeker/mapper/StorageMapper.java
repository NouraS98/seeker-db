package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.storageDocument.StorageDocumentDto;
import com.seekerhub.seeker.entity.StorageDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StorageMapper extends BaseMapper<StorageDocument, StorageDocumentDto> {
}
