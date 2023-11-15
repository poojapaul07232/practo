package com.practo.Service;

import com.practo.Repository.DoctorRepo;
import com.practo.Repository.PatientRepo;
import com.practo.Repository.ReviewRepo;
import com.practo.entity.Doctor;
import com.practo.entity.Patient;
import com.practo.entity.Review;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private ReviewRepo reviewRepo;

    public Review createReview(Review review){
        try {
            Doctor docId = doctorRepo.findById(review.getDoctorId()).get();
            Patient patId = patientRepo.findById(review.getPatientId()).get();
            if(docId !=null || patId!=null){
                Review savedReview=reviewRepo.save(review);
                return  savedReview;

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Review> getReviewByDoctorId(long doctorId){
       List<Review> reviews =  reviewRepo.findByDoctorId(doctorId);
       return  reviews;

    }
}
