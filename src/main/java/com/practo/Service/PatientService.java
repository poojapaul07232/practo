package com.practo.Service;

import com.practo.Repository.PatientRepo;
import com.practo.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;
    public Patient createPatient(Patient patient){
        Patient p=patientRepo.save(patient);
        return  p;
    }

}
