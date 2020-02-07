package com.seekerhub.seeker.mapper;

import com.seekerhub.seeker.dto.Skill.SkillDto;
import com.seekerhub.seeker.entity.Skill;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SkillMapper extends BaseMapper<Skill, SkillDto>{

}