package com.seekerhub.seeker.service.freelancer;

import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.entity.Employer;
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
    public FreelancerDto setMaroof(long id, String maarof_account) {
        if(!freelancerRepository.existsById(id))
            throw new GenericException("The freelancer was not found");
        Freelancer freelancer = freelancerRepository.getOne(id);

        freelancer.setMaarof_account(maarof_account);
        freelancerRepository.save(freelancer);

        return freelancerMapper.toDto(freelancer);
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

    @Override
    public FreelancerDto getRatingValues(long id) {

        if (!freelancerRepository.existsById(id))
            throw new GenericException("The freelancer was not found");
        Freelancer freelancer = freelancerRepository.getOne(id);



        return null;
    }

    @Override
    public void setRatingValues(long id, int num_of_ratings, int total_quality_of_work, int total_response_time) {
        if (!freelancerRepository.existsById(id))
            throw new GenericException("The freelancer was not found");

        Freelancer freelancer = freelancerRepository.getOne(id);
        freelancer.setNum_of_ratings(num_of_ratings);
        freelancer.setTotal_quality_of_work(total_quality_of_work);
        freelancer.setTotal_response_time(total_response_time);

        freelancerRepository.save(freelancer);
    }

    @Override
    public void setNumberOfWorkedOnProjects(long id) {
        if(!freelancerRepository.existsById(id))
            throw new GenericException("The freelancer was not found");
        Freelancer freelancer = freelancerRepository.getOne(id);

        freelancer.setNum_of_hired_projects(freelancer.getNum_of_hired_projects()+1);
        freelancerRepository.save(freelancer);
    }
}
