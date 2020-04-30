package com.seekerhub.seeker.scheduling;

import com.seekerhub.seeker.dto.Milestone.MilestoneDto;
import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.entity.Milestone;
import com.seekerhub.seeker.mapper.MilestoneMapper;
import com.seekerhub.seeker.service.Milestone.MilestoneService;
import com.seekerhub.seeker.service.Project.ProjectService;
import com.seekerhub.seeker.service.PushNotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProjectExpiryScheduler {

    @Autowired
    ProjectService projectService;

    @Autowired
    PushNotificationsService pushNotificationsService;

    @Autowired
    MilestoneService milestoneService;

    @Autowired
    MilestoneMapper milestoneMapper;

    @Scheduled(cron = "0 0 21 * * *")
    @Transactional
    public void sendNotification(){
        List<ProjectDto> projectDtoList = projectService.findProjectsBeforeExpiry();
        projectDtoList.forEach(projectDto -> {
            if(projectDto.getEmployer().getUser().isEnableProjectExpiryNoti() && projectDto.getEmployer().getUser().isLogin())
            pushNotificationsService.sendBeforeExpiry(projectDto);

        });
    }

    @Scheduled(cron = "0 7 22 * * *")
    @Transactional
    public void sendNotificationbeforeMilestoneDeadline(){

        List<Milestone> milestoneDtos = milestoneService.findMilestoneBeforeByDeadline();
        milestoneDtos.forEach(milestoneDto -> {
            if(milestoneDto.getProject().getEmployer().getUser().isEnableMilestoneDLNoti() && milestoneDto.getProject().getEmployer().getUser().isLogin())
            pushNotificationsService.sendBeforeMilestone(milestoneMapper.toDto(milestoneDto) , milestoneDto.getProject().getEmployer().getUser().getToken_id());

        });
    }

}
