package com.practo.controller;

import com.practo.Repository.DoctorRepo;
import com.practo.Service.ReviewService;
import com.practo.entity.Doctor;
import com.practo.entity.Review;
import com.practo.payload.DoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private DoctorRepo doctorRepo;
    @PostMapping
    public ResponseEntity<Review> createReviews(@RequestBody Review review)
    {
       Review r= reviewService.createReview(review);
       return new ResponseEntity<>(r, HttpStatus.CREATED);
    }

    //based on doctor Id give all the details list
    @GetMapping("/{docId}")
    public ResponseEntity<DoctorDto> getReviewByDoctorId(@PathVariable long docId){
       Doctor doctor= doctorRepo.findById(docId).get();
       List<Review>  reviews=reviewService.getReviewByDoctorId(docId);
       double totalRating=0;
       //finding the %
      for(Review review:reviews){
          totalRating += review.getRating();
      }
      double avgRating =totalRating/reviews.size();
      double ratingPercentage= (avgRating/5.0) * 100.0;

       DoctorDto doctorDto = new DoctorDto();
            doctorDto.setDoctor(doctor);
            doctorDto.setReviews(reviews);
            doctorDto.setRatingPercentage(ratingPercentage);
            return new ResponseEntity<>(doctorDto,HttpStatus.CREATED);

    }

}
