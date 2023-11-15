package com.practo.config;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimeSlotManager
{
    private List<String> availableTimeSlots;

    public TimeSlotManager(List<String> initalTimeSlots){
        this.availableTimeSlots=initalTimeSlots;

    }
    public  List<String> getAvailableTimeSlots( ){
        return availableTimeSlots;


    }


    public  void setAvailableTimeSlots(List<String> timeSlots){
        this.availableTimeSlots=timeSlots;
    }
}
