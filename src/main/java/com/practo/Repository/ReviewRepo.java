package com.practo.Repository;

import com.practo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review,Long> {
     List<Review>  findByDoctorId (long id);
}
