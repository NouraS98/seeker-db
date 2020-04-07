package com.seekerhub.seeker.service.Project;

import com.seekerhub.seeker.dto.Category.CategoryDto;
import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.dto.storageDocument.StorageDocumentDto;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public interface ProjectService {
    ProjectDto save(ProjectDto projectDto);
    List<ProjectDto> findAll();
    ProjectDto findById(long id);
    void setStatus(long id);
    List<ProjectDto> findByStatusAndEmployer(String status, EmployerDto employer);
    //todo new 1 hind
    List<ProjectDto> findByStatus(String status);

    ProjectDto saveWithAttachments(ProjectDto projectDto, List<MultipartFile> attachments);

    void deleteAttachmentById(long id, long attachmentId);

    StorageDocumentDto addAttachment(long id, MultipartFile attachment);


    List<ProjectDto> findByCategory(CategoryDto categoryDto);
    //todo raghad add extend and delete funcrions
    //delete
    void deleteProjectById(long id);
    //extend
    void extendProjectById(long id, LocalDateTime localDateTime);

    List<ProjectDto> findProjectsBeforeExpiry();




}
