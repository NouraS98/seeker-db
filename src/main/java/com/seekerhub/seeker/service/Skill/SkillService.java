package com.seekerhub.seeker.service.Skill;

import com.seekerhub.seeker.dto.Skill.SkillDto;

import java.util.List;

public interface SkillService {

    SkillDto save(SkillDto skillDto);
    List<SkillDto> findAll();
    SkillDto findById(long id);

}
