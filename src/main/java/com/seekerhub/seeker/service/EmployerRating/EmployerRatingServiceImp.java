package com.seekerhub.seeker.service.EmployerRating;

import com.seekerhub.seeker.dto.EmployerRating.EmployerRatingDto;
import com.seekerhub.seeker.entity.Employer;
import com.seekerhub.seeker.entity.EmployerRating;
import com.seekerhub.seeker.mapper.EmployerRatingMapper;
import com.seekerhub.seeker.repository.EmployerRatingRepository;
import com.seekerhub.seeker.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerRatingServiceImp implements EmployerRatingService {
    @Autowired
    EmployerRatingRepository employerRatingRepository;
    @Autowired
    EmployerRatingMapper employerRatingMapper;


    @Override
    public EmployerRatingDto save(EmployerRatingDto employerRatingDto) {
        EmployerRating employerRating = employerRatingMapper.toEntity(employerRatingDto);
        EmployerRating employerRatingToSave = employerRatingRepository.save(employerRating);
        return employerRatingMapper.toDto(employerRatingToSave);
    }

    @Override
    public List<EmployerRatingDto> findAll() {
        return employerRatingMapper.toDtos(employerRatingRepository.findAll());
    }

    @Override
    public EmployerRatingDto findById(long id) {
        return employerRatingMapper.toDto(employerRatingRepository.getOne(id));
    }

    @Override
    public double calculateTotalRatings(long employer_id) {
        /**
         * The calculation is correct,
         * the only problem is to assure that the passed id is actually for an existing employer.
         */
//        if(!employerRatingRepository.existsById(employer_id))
//            throw new GenericException("The employer was not found");

        double totalEmployerRatings = 0;

        List<EmployerRating> employersRatings = employerRatingRepository.findAll();
        List<EmployerRating> myEmployerRatings = new ArrayList<>();

        //Getting all rating objects for a specified employer
        for (int i = 0; i< employersRatings.size(); i++){
            if (employersRatings.get(i).getEmployer().getId() == employer_id)
                myEmployerRatings.add(employersRatings.get(i));
        }//end

        //looping through the specified employer's rating objects array
        // to calculate his/her total ratings
        for (int i =0; i< myEmployerRatings.size(); i++){

            totalEmployerRatings+=  ( (double)(myEmployerRatings.get(i).getCommunication() + (double)myEmployerRatings.get(i).getOnTimePayment() + (double)myEmployerRatings.get(i).getProfessionalism()) / 3.0);

        }

        double average = totalEmployerRatings/myEmployerRatings.size();

        return average;
    }
}
