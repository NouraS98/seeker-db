package com.seekerhub.seeker.service.Skill;

import com.seekerhub.seeker.dto.Skill.SkillDto;
import com.seekerhub.seeker.entity.Skill;
import com.seekerhub.seeker.mapper.SkillMapper;
import com.seekerhub.seeker.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImp implements SkillService {
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    SkillMapper skillMapper;

    @Override
    public SkillDto save(SkillDto skillDto) {
        Skill skill = skillMapper.toEntity(skillDto);
        Skill skillToSave = skillRepository.save(skill);
        return skillMapper.toDto(skillToSave);
    }

    @Override
    public List<SkillDto> findAll() {
        return skillMapper.toDtos(skillRepository.findAll());
    }

    @Override
    public SkillDto findById(long id) {
        return skillMapper.toDto(skillRepository.getOne(id));
    }


}
