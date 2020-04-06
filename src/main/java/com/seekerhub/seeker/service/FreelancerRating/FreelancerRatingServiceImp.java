package com.seekerhub.seeker.service.FreelancerRating;

import com.seekerhub.seeker.dto.FreelancerRating.FreelancerRatingDto;

import com.seekerhub.seeker.entity.EmployerRating;
import com.seekerhub.seeker.entity.FreelancerRating;
import com.seekerhub.seeker.mapper.FreelancerRatingMapper;
import com.seekerhub.seeker.repository.FreelancerRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FreelancerRatingServiceImp implements FreelancerRatingService {
    @Autowired
    FreelancerRatingRepository freelancerRatingRepository;
    @Autowired
    FreelancerRatingMapper freelancerRatingMapper;

    @Override
    public FreelancerRatingDto save(FreelancerRatingDto freelancerRatingDto) {
        FreelancerRating freelancerRating = freelancerRatingMapper.toEntity(freelancerRatingDto);
        FreelancerRating freelancerRatingToSave = freelancerRatingRepository.save(freelancerRating);
        return freelancerRatingMapper.toDto(freelancerRatingToSave);
    }

    @Override
    public List<FreelancerRatingDto> findAll() {
        return freelancerRatingMapper.toDtos(freelancerRatingRepository.findAll());
    }

    @Override
    public FreelancerRatingDto findById(long id) {
        return freelancerRatingMapper.toDto(freelancerRatingRepository.getOne(id));
    }

//    public double calculateTotalRatings(long employer_id) {
//        /**
//         * The calculation is correct,
//         * the only problem is to assure that the passed id is actually for an existing employer.
//         */
////        if(!employerRatingRepository.existsById(employer_id))
////            throw new GenericException("The employer was not found");
//
//        double totalEmployerRatings = 0;
//
//        List<EmployerRating> employersRatings = employerRatingRepository.findAll();
//        List<EmployerRating> myEmployerRatings = new ArrayList<>();
//
//        //Getting all rating objects for a specified employer
//        for (int i = 0; i< employersRatings.size(); i++){
//            if (employersRatings.get(i).getEmployer().getId() == employer_id)
//                myEmployerRatings.add(employersRatings.get(i));
//        }//end
//
//        //looping through the specified employer's rating objects array
//        // to calculate his/her total ratings
//        for (int i =0; i< myEmployerRatings.size(); i++){
//
//            totalEmployerRatings+=  ( (double)(myEmployerRatings.get(i).getCommunication() + (double)myEmployerRatings.get(i).getOnTimePayment() + (double)myEmployerRatings.get(i).getProfessionalism()) / 3.0);
//
//        }
//
//        double average = totalEmployerRatings/myEmployerRatings.size();
//
//        return average;
//    }

    @Override
    public double calculateTotalRatings(long freelancer_id) {

        double totalFreelancerRatings = 0;

        List<FreelancerRating> freelancerRatings = freelancerRatingRepository.findAll();
        List<FreelancerRating> myFreelancerRatings = new ArrayList<>();

        //Getting all ratings objects for a specified freelancer
        for (int i = 0; i< freelancerRatings.size(); i++){
            if (freelancerRatings.get(i).getFreelancer().getId() == freelancer_id)
                myFreelancerRatings.add(freelancerRatings.get(i));
        }//End for loop


        //looping through the specified freelancer's rating objects array
        // to calculate the total ratings
        for (int i = 0; i< myFreelancerRatings.size(); i++){
            totalFreelancerRatings+= ( ((double)(myFreelancerRatings.get(i)).getCommunication()
                    + (double)(myFreelancerRatings.get(i).getProfessionalism())
                    + (double)(myFreelancerRatings.get(i).getQualityOfWork())
                    + (double)(myFreelancerRatings.get(i).getOnBudget())
                    + (double)(myFreelancerRatings.get(i).getOnTime()) )/5.0 );
        }//end

        double avgRatings = totalFreelancerRatings/myFreelancerRatings.size();

        return avgRatings;
    }
}
