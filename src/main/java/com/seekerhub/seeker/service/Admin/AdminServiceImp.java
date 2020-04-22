package com.seekerhub.seeker.service.Admin;

import com.seekerhub.seeker.dto.Admin.AdminDto;
import com.seekerhub.seeker.dto.Skill.SkillDto;
import com.seekerhub.seeker.entity.Admin;
import com.seekerhub.seeker.entity.Skill;
import com.seekerhub.seeker.mapper.AdminMapper;
import com.seekerhub.seeker.mapper.SkillMapper;
import com.seekerhub.seeker.repository.AdminRepository;
import com.seekerhub.seeker.repository.SkillRepository;
import com.seekerhub.seeker.service.Skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AdminMapper adminMapper;

    @Override
    public AdminDto save(AdminDto skillDto) {
        Admin admin = adminMapper.toEntity(skillDto);
        Admin adminToSave = adminRepository.save(admin);
        return adminMapper.toDto(adminToSave);
    }

    @Override
    public List<AdminDto> findAll() {
        return adminMapper.toDtos(adminRepository.findAll());
    }

    @Override
    public AdminDto findById(long id) {
        return adminMapper.toDto(adminRepository.getOne(id));
    }


}
