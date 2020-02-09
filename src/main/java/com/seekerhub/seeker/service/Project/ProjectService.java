package com.seekerhub.seeker.service.Project;

import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.dto.storageDocument.StorageDocumentDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjectService {
    ProjectDto save(ProjectDto projectDto);
    List<ProjectDto> findAll();
    ProjectDto findById(long id);
    void setStatus(long id);

    ProjectDto saveWithAttachments(ProjectDto projectDto, List<MultipartFile> attachments);

    void deleteAttachmentById(long id, long attachmentId);

    StorageDocumentDto addAttachment(long id, MultipartFile attachment);
}
