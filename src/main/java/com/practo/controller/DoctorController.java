package com.practo.controller;
import com.practo.Service.DoctorService;
import com.practo.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctors")
public class DoctorController {


        @Autowired
        private DoctorService doctorService;

        @PostMapping("/add")
        public Doctor addDoctor(@RequestBody Doctor doctor) {
            return doctorService.addDoctor(doctor);
        }


       //http://localhost:8080/doctors/search?search=Cardiology
        @GetMapping("/search")
        public List<Doctor> searchDoctor(@RequestParam String search){
            return doctorService.searchDoctorsByNameOrSpecialization(search);
        }

    //http://localhost:8080/doctors/Cardiology
//    @GetMapping("/{search}")
//    public List<Doctor> searchDoctor(@PathVariable String search){
//        return doctorService.searchDoctorsByNameOrSpecialization(search);
//    }



}


