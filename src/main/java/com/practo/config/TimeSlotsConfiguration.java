package com.practo.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class TimeSlotsConfiguration {

    @Bean
    public  TimeSlotManager  timeSlotsManager()
    {
      List<String> availableTimeSlots=new ArrayList<>();

            // Your logic to initialize the available time slots goes here.
            availableTimeSlots.add("10:15 AM");
            availableTimeSlots.add("11:15 AM");
            availableTimeSlots.add("12:15 PM");

        return new TimeSlotManager(availableTimeSlots);
        }
}
