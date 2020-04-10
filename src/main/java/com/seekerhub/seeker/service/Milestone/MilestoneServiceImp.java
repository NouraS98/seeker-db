package com.seekerhub.seeker.service.Milestone;

import com.seekerhub.seeker.dto.Milestone.MilestoneDto;
import com.seekerhub.seeker.entity.Milestone;
import com.seekerhub.seeker.entity.Project;
import com.seekerhub.seeker.exception.GenericException;
import com.seekerhub.seeker.mapper.MilestoneMapper;
import com.seekerhub.seeker.repository.MilestoneRepository;
import com.seekerhub.seeker.service.Contract.ContractService;
import com.seekerhub.seeker.service.Project.ProjectService;
import com.seekerhub.seeker.service.PushNotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class MilestoneServiceImp implements MilestoneService {
    @Autowired
    MilestoneRepository milestoneRepository;
    @Autowired
    MilestoneMapper milestoneMapper;
    @Autowired
    ProjectService projectService;

    @Autowired
    ContractService contractService;

    @Autowired
    PushNotificationsService pushNotificationsService;

    @Override
    public MilestoneDto save(MilestoneDto milestoneDto) {
        Milestone milestone = milestoneMapper.toEntity(milestoneDto);
        Milestone milestoneToSave = milestoneRepository.save(milestone);
        return milestoneMapper.toDto(milestoneToSave);
    }

    @Override
    public List<MilestoneDto> findAll() {
        return milestoneMapper.toDtos(milestoneRepository.findAll());
    }

    @Override
    public MilestoneDto findById(long id) {
        return milestoneMapper.toDto(milestoneRepository.getOne(id));
    }

    @Override
    public void deleteById(long id) {

        if(!milestoneRepository.existsById(id))
            throw new GenericException("The milestone was not found");

       milestoneRepository.deleteById(id);
    }

    @Override
    public List<Milestone> findMilestoneBeforeByDeadline() {
        LocalDate localDate = LocalDate.now().plusDays(1);
        LocalDateTime startOfDay = localDate.atStartOfDay();
        LocalDateTime endOfDay = localDate.plusDays(1).atStartOfDay();
        List<Milestone> milestones = milestoneRepository.findByDeadlineAndStatus(startOfDay,endOfDay,"0");

        return milestones;
    }

    @Override
    public MilestoneDto updateStatus(long id) {
        Milestone milestone = milestoneRepository.getOne(id);
        milestone.setStatus("1");
        milestone = milestoneRepository.save(milestone);
        AtomicBoolean isPaid= new AtomicBoolean(true);
        Project project = milestone.getProject();
        milestone.getProject().getMilestones().forEach(milestone1 -> {
            if(milestone1.getStatus().equals("0")){
                isPaid.set(false);
            }
        });
        if(isPaid.get()){
            projectService.setStatus(project.getId(),"2");
            contractService.updateStatus(project.getId(), "1");
        }
        return milestoneMapper.toDto(milestone);
    }


}
