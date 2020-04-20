package com.seekerhub.seeker.service.freelancer;

import com.amazonaws.services.transfer.model.ListedServer;
import com.seekerhub.seeker.dto.Freelancer.FreelancerDto;
import com.seekerhub.seeker.entity.Freelancer;
import com.seekerhub.seeker.entity.Skill;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface FreelancerService {
    FreelancerDto save(FreelancerDto freelancerDto);
    List<FreelancerDto> findAll();
    FreelancerDto findById(long id);
    FreelancerDto findByUserId(long user_id);
    FreelancerDto setMaroof(long id, String maarof_account);
    FreelancerDto setSkills(long id, Set<Skill> skills);

    String getMaroof(long id);
    FreelancerDto getRatingValues(long id);

    void setRatingValues(long id, int num_of_ratings, int total_quality_of_work, int total_response_time);
    void setNumberOfWorkedOnProjects(long id);

    void setFreelancerIban(long id, String fullName, String ibanNumber);
    Set<FreelancerDto> findBySkills(Collection<Skill> skills);

}
