package com.seekerhub.seeker.service.freelancer;

import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.entity.Freelancer;
import com.seekerhub.seeker.entity.Skill;
import com.seekerhub.seeker.entity.User;
import com.seekerhub.seeker.exception.GenericException;
import com.seekerhub.seeker.mapper.FreelancerMapper;
import com.seekerhub.seeker.repository.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FreelancerServiceImp implements FreelancerService {
    @Autowired
    FreelancerRepository freelancerRepository;

    @Autowired
    FreelancerMapper freelancerMapper;

    @Override
    public FreelancerDto save(FreelancerDto freelancerDto) {
        Freelancer freelancer = freelancerMapper.toEntity(freelancerDto);
        Freelancer freelancerToSave = freelancerRepository.save(freelancer);
        return freelancerMapper.toDto(freelancerToSave);
    }

    @Override
    public List<FreelancerDto> findAll() {
        return freelancerMapper.toDtos(freelancerRepository.findAll());
    }

    @Override
    public FreelancerDto findById(long id) {
        return freelancerMapper.toDto(freelancerRepository.getOne(id));
    }

    @Override
    public FreelancerDto findByUserId(long user_id) {
        return freelancerMapper.toDto(freelancerRepository.findByUserId(user_id));
    }

    @Override
    public void setMaroof(long id, String maarof_account) {
        if(!freelancerRepository.existsById(id))
            throw new GenericException("The freelancer was not found");
        Freelancer freelancer = freelancerRepository.getOne(id);

        freelancer.setMaarof_account(maarof_account);
        freelancerRepository.save(freelancer);
    }

    @Override
        public FreelancerDto setSkills(long id, Set<Skill> skills) {
        if(!freelancerRepository.existsById(id))
            throw new GenericException("The freelancer was not found");
        Freelancer freelancer = freelancerRepository.getOne(id);

        freelancer.setSkills(skills);
        freelancerRepository.save(freelancer);
        return  freelancerMapper.toDto(freelancerRepository.getOne(freelancer.getId()));
    }

    @Override
    public String getMaroof(long id) {
        if (!freelancerRepository.existsById(id))
            throw new GenericException("The freelancer was not found");
        Freelancer freelancer = freelancerRepository.getOne(id);

        return freelancer.getMaarof_account();

    }
}
