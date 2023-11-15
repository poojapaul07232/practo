package com.practo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
    private long doctorId;
    private  long patientId;
    private int rating;
}
