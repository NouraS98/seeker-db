package com.seekerhub.seeker.service.Project;

import com.seekerhub.seeker.dto.Category.CategoryDto;
import com.seekerhub.seeker.dto.Employer.EmployerDto;
import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.dto.storageDocument.StorageDocumentDto;
import com.seekerhub.seeker.entity.*;
import com.seekerhub.seeker.enums.StorageEnum;
import com.seekerhub.seeker.exception.GenericException;
import com.seekerhub.seeker.mapper.*;
import com.seekerhub.seeker.model.FileUpload;
import com.seekerhub.seeker.repository.FreelancerRepository;
import com.seekerhub.seeker.repository.ProjectRepository;
import com.seekerhub.seeker.service.PushNotificationsService;
import com.seekerhub.seeker.service.freelancer.FreelancerService;
import com.seekerhub.seeker.service.freelancer.FreelancerServiceImp;
import com.seekerhub.seeker.service.upload.UploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class ProjectServiceImp implements ProjectService{

    @Value("${app.file-upload.attachment}")
    private String ATTACHMENT_SPACE_NAME;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    StorageMapper storageMapper;

    @Autowired
    EmployerMapper employerMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    private UploadService uploadService;


    @Autowired
    PushNotificationsService pushNotificationsService;

    @Autowired
    FreelancerService freelancerService;


    @Override
    public ProjectDto save(ProjectDto projectDto) {
        Project project = projectMapper.toEntity(projectDto);
        //TODO:
        project.getMilestones().forEach(project::addMilestone);

        Project projectToSave = projectRepository.save(project);
        Set<FreelancerDto> freelancerDtoSet = freelancerService.findBySkills(projectToSave.getSkills());
        freelancerDtoSet.forEach( freelancerDto -> {
                    pushNotificationsService.sendToFreelancerAccordingToSkills(projectDto,freelancerDto.getUser().getToken_id());
                }
        );
        return projectMapper.toDto(projectToSave);
    }

    @Override
    @Transactional
    public ProjectDto saveWithAttachments(ProjectDto projectDto, List<MultipartFile> attachments) {

        Project project = projectMapper.toEntity(projectDto);
        project.getMilestones().forEach(project::addMilestone);
        Project projectToSave = projectRepository.save(project);

        for (int i = 0; i < attachments.size(); i++) {
            String key = "attachment_" + projectToSave.getId() + "_" + (new Date().getTime());

            MultipartFile file = attachments.get(i);

            // Setting file name
            String name = file.getOriginalFilename();

            try {
                // Upload avatar to Avatar Space (DigitalOcean)
                FileUpload fileUpload = uploadService.upload(ATTACHMENT_SPACE_NAME, key, file);

                // If upload is successful, then create new Storage Document Entity with type AVATAR and set user avatar and save user.
                if (fileUpload.isSuccess()) {
                    StorageDocument storageDocument = new StorageDocument(key, name, StorageEnum.PROJECT_ATTACHMENT, fileUpload.getUrl(), file.getContentType());
                    projectToSave.getAttachments().add(storageDocument);
                } else {
                    throw new GenericException("Could not upload avatar");
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new GenericException("Could not upload avatar");
            }
        }

        projectToSave = projectRepository.save(projectToSave);



        return projectMapper.toDto(projectToSave);
    }

    @Override
    public List<ProjectDto> findAll() {
        return projectMapper.toDtos(projectRepository.findAll());
    }

    @Override
    public ProjectDto findById(long id) {
        return projectMapper.toDto(projectRepository.getOne(id));
    }

    @Override
    public void setStatus(long id) {
    if(!projectRepository.existsById(id))
        throw new GenericException("The project was not found");
     Project project = projectRepository.getOne(id);
     project.setStatus("1");
     projectRepository.save(project);
    }

    @Override
    public List<ProjectDto> findByStatusAndEmployer(String status, EmployerDto employer) {
        if (!projectRepository.existsByStatus(status))
            throw new GenericException("No Projects");

        return projectMapper.toDtos(projectRepository.findByStatusAndEmployer(status,employerMapper.toEntity(employer)));

    }

    //todo new 2 hind
    @Override
    public List<ProjectDto> findByStatus(String status) {
        if (!projectRepository.existsByStatus(status))
            throw new GenericException("No Projects");

        return projectMapper.toDtos(projectRepository.findByStatus(status));
    }

    @Override
    public StorageDocumentDto addAttachment(long id, MultipartFile file) {
        if (!projectRepository.existsById(id))
            throw new GenericException("Project doesn't exist");

        Project project = projectRepository.getOne(id);

        String key = "attachment_" + project.getId() + "_" + (new Date().getTime());


        // Setting file name
        String name = file.getOriginalFilename();

        try {
            // Upload avatar to Avatar Space (DigitalOcean)
            FileUpload fileUpload = uploadService.upload(ATTACHMENT_SPACE_NAME, key, file);

            // If upload is successful, then create new Storage Document Entity with type AVATAR and set user avatar and save user.
            if (fileUpload.isSuccess()) {
                StorageDocument storageDocument = new StorageDocument(key, name, StorageEnum.PROJECT_ATTACHMENT, fileUpload.getUrl(), file.getContentType());
                project.getAttachments().add(storageDocument);
                Project projectToSave = projectRepository.save(project);

                return storageMapper.toDto(projectToSave.getAttachments().get(projectToSave.getAttachments().size() - 1));
            } else {
                throw new GenericException("Could not upload avatar");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new GenericException("Could not upload avatar");
        }
    }



    @Override
    public void deleteAttachmentById(long id, long attachmentId) {
        if (!projectRepository.existsById(id))
            throw new GenericException("Project doesn't exist");

        Project project = projectRepository.getOne(id);
        Optional<StorageDocument> storageDocumentToDelete = project.getAttachments().stream().filter(storageDocument -> storageDocument.getId() == attachmentId).findFirst();
        if (!storageDocumentToDelete.isPresent()) {
            throw new GenericException("Attachment doesn't exist");
        }
        project.getAttachments().remove(storageDocumentToDelete.get());
        projectRepository.save(project);
    }


    @Override
    public List<ProjectDto> findByCategory(CategoryDto categoryDto) {
        if (!projectRepository.existsByCategory(categoryMapper.toEntity(categoryDto)))
            throw new GenericException("No Projects");

        return projectMapper.toDtos(projectRepository.findByCategory(categoryMapper.toEntity(categoryDto)));
    }


   // delete not yest
   public void deleteProjectById(long id){
       if (!projectRepository.existsById(id))
           throw new GenericException("Project doesn't exist");

       projectRepository.deleteById(id);

    }
  //  extend not yet
   public void extendProjectById(long id, LocalDateTime localDateTime){
       if (!projectRepository.existsById(id))
           throw new GenericException("Project doesn't exist");

       Project project = projectRepository.getOne(id);
       project.setExpiry_date(localDateTime);
       projectRepository.save(project);
    }

    @Override
    public List<ProjectDto> findProjectsBeforeExpiry() {

       LocalDate localDate = LocalDate.now().plusDays(1);
       LocalDateTime startOfDay = localDate.atStartOfDay();
        LocalDateTime endOfDay = localDate.plusDays(1).atStartOfDay();
        List<Project> projects = projectRepository.findByExpiry_dateAndStatus(startOfDay,endOfDay,"0");

        return projectMapper.toDtos(projects);
    }

    public LocalDateTime convertDateToLocaleDateTime(Date date){

        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
     return localDateTime;
    }


}
