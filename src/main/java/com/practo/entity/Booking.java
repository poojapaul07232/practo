package com.practo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="booking")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Booking {
     @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     private long doctorId;
     private long patientId;
     private String bookingTime;



}