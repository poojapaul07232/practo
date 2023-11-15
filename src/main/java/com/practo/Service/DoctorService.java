package com.practo.Service;

import com.practo.entity.Doctor;
import com.practo.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.DatagramPacket;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);

    }

    public List<Doctor> searchDoctorsByNameOrSpecialization(String search){
        return  doctorRepository.findByByNameOrSpecialization(search);
    }
}

