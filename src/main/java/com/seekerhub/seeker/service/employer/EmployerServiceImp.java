package com.seekerhub.seeker.service.employer;

import com.seekerhub.seeker.dto.Employer.EmployerDto;

import com.seekerhub.seeker.entity.Employer;
import com.seekerhub.seeker.entity.Project;
import com.seekerhub.seeker.entity.User;
import com.seekerhub.seeker.exception.GenericException;
import com.seekerhub.seeker.mapper.EmployerMapper;
import com.seekerhub.seeker.repository.EmployerRepository;
import com.seekerhub.seeker.repository.ProjectRepository;
import com.seekerhub.seeker.service.Project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerServiceImp implements EmployerService {
    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    EmployerMapper employerMapper;

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public EmployerDto save(EmployerDto employerDto) {
        Employer employer = employerMapper.toEntity(employerDto);
        Employer employerToSave = employerRepository.save(employer);
        return employerMapper.toDto(employerToSave);
    }

    @Override
    public List<EmployerDto> findAll() {
        return employerMapper.toDtos(employerRepository.findAll());
    }

    @Override
    public EmployerDto findById(long id) {
        return employerMapper.toDto(employerRepository.getOne(id));
    }

    @Override
    public EmployerDto getByUserId(long user_id) {
        return employerMapper.toDto(employerRepository.getByUserId(user_id));
    }

    //Employer rating required methods
    @Override
    public List<Integer> getEmployerRatingValues(long id) {

        if(!employerRepository.existsById(id))
            throw new GenericException("The employer was not found");
        Employer employer = employerRepository.getOne(id);

        //Values will be returned in this order
        //  private int  num_of_ratings;
        //  private int  response_time;
        //  private int  total_on_time_payment;

        List<Integer> list = new ArrayList<>();

        list.add(employer.getNum_of_ratings());
        list.add(employer.getResponse_time());
        list.add(employer.getTotal_on_time_payment());

        return list;
    }

    @Override
    public float getTotalEmployerRatings(long id) {
        if(!employerRepository.existsById(id))
            throw new GenericException("The employer was not found");
        Employer employer = employerRepository.getOne(id);

        return employer.getTotal_emp_ratings();
    }

    @Override
    public void setRatingValues(long id, int num_of_ratings, int response_time, int total_on_time_payment, float total_emp_ratings, long project_id) {
        if(!employerRepository.existsById(id))
            throw new GenericException("The employer was not found");
        Employer employer = employerRepository.getOne(id);

        employer.setNum_of_ratings(num_of_ratings);
        employer.setResponse_time(response_time);
        employer.setTotal_on_time_payment(total_on_time_payment);
        employer.setTotal_emp_ratings(total_emp_ratings);

//        if (!projectRepository.existsById(project_id))
//            throw new GenericException("The project was not found");
//        Project project = projectRepository.getOne(project_id);
//        project.setDid_fr_rate(true);

        projectService.setFreelancerRated(project_id, true);

//        projectRepository.save(project);

        employerRepository.save(employer);


    }

    @Override
    public void setNumberOfPostedProjects(long id) {
        if(!employerRepository.existsById(id))
            throw new GenericException("The employer was not found");
        Employer employer = employerRepository.getOne(id);

        employer.setNum_of_posted_Projects(employer.getNum_of_posted_Projects()+1);
        employerRepository.save(employer);
    }
}
