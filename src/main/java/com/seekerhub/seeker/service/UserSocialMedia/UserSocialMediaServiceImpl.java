package com.seekerhub.seeker.service.UserSocialMedia;

import com.seekerhub.seeker.dto.Skill.SkillDto;

import com.seekerhub.seeker.dto.user.UserSocialMediaDto;
import com.seekerhub.seeker.entity.Skill;

import com.seekerhub.seeker.entity.UserSocialMedia;
import com.seekerhub.seeker.mapper.SkillMapper;
import com.seekerhub.seeker.mapper.UserMapper;
import com.seekerhub.seeker.mapper.UserSocialMediaMapper;
import com.seekerhub.seeker.repository.SkillRepository;

import com.seekerhub.seeker.repository.UserSocialMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSocialMediaServiceImpl implements UserSociaMediaService {

    @Autowired
    UserSocialMediaRepository userSocialMediaRepository;
    @Autowired
    UserSocialMediaMapper userSocialMediaMapper;



    @Override
    public UserSocialMediaDto save(UserSocialMediaDto userSocialMediaDto) {
        UserSocialMedia userSocialMedia = userSocialMediaMapper.toEntity(userSocialMediaDto);
        UserSocialMedia userSocialMediaToSave = userSocialMediaRepository.save(userSocialMedia);
        return userSocialMediaMapper.toDto(userSocialMediaToSave);
    }

    @Override
    public List<UserSocialMediaDto> findAll() {
        return userSocialMediaMapper.toDtos(userSocialMediaRepository.findAll());
    }

    @Override
    public UserSocialMediaDto findById(long id) {
        return userSocialMediaMapper.toDto(userSocialMediaRepository.getOne(id));
    }


}