package com.seekerhub.seeker.repository;

import com.seekerhub.seeker.entity.StorageDocument;
import com.seekerhub.seeker.enums.StorageEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageDocumentRepository extends JpaRepository<StorageDocument, Long> {
    List<StorageDocument> findByType(StorageEnum type);
}
