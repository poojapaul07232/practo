package com.practo.Repository;

import com.practo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepo extends JpaRepository<Doctor,Long>
{
@Query("Select d from Doctor d where  d.name Like %:search% OR d.specialization Like %:search%")
List<Doctor> findByByNameOrSpecialization(@Param("search") String search);


//-----------------------------another way----------------------------------------------------------------------
//    List<Doctor> findByNameIgnoreCaseContaining(String name);
//    List<Doctor> findBySpecializationIgnoreCaseContaining(String specialization);


}
