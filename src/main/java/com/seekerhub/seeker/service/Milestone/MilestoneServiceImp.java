package com.seekerhub.seeker.service.Milestone;

import com.seekerhub.seeker.dto.Milestone.MilestoneDto;
import com.seekerhub.seeker.dto.Skill.SkillDto;
import com.seekerhub.seeker.entity.Milestone;
import com.seekerhub.seeker.entity.Skill;
import com.seekerhub.seeker.mapper.MilestoneMapper;
import com.seekerhub.seeker.mapper.SkillMapper;
import com.seekerhub.seeker.repository.MilestoneRepository;
import com.seekerhub.seeker.repository.SkillRepository;
import com.seekerhub.seeker.service.Skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilestoneServiceImp implements MilestoneService {
    @Autowired
    MilestoneRepository milestoneRepository;
    @Autowired
    MilestoneMapper milestoneMapper;

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


}
