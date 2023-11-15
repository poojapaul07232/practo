package com.practo.controller;

import com.practo.Service.PatientService;
import com.practo.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;
   @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
          Patient p=   patientService.createPatient(patient);
        return  new ResponseEntity<>(p, HttpStatus.CREATED);

    }

}
