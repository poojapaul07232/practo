package com.practo.Service;

import com.practo.Repository.BookingRepo;
import com.practo.config.TimeSlotManager;
import com.practo.entity.Booking;
import com.practo.payload.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private TimeSlotManager timeSlotManager;

    public void bookAnAppointment(BookingDto bookingDto){
        List <String> availableTimeSlots=timeSlotManager.getAvailableTimeSlots();
//        availableTimeSlots.add("10:15 Am");
//        availableTimeSlots.add("11:15 Am");
//        availableTimeSlots.add("12:15 Am");

        Booking booking=new Booking();

        for(String slots:availableTimeSlots){
            if(slots.equals(bookingDto.getBookingTime())){
                availableTimeSlots.remove(slots);
                booking.setBookingTime(bookingDto.getBookingTime());

                availableTimeSlots.remove(slots);
                timeSlotManager.setAvailableTimeSlots(availableTimeSlots);
            }
        }







        //schedule the task to run every 24 hours
        ScheduledExecutorService executor= Executors.newScheduledThreadPool(5) ;
            executor.scheduleAtFixedRate(() -> {
                System.out.println("executing the code evry 24 hours");
                availableTimeSlots.add("10:15 Am");
                availableTimeSlots.add("11:15 Am");
                availableTimeSlots.add("12:15 Am");
            }, 0, 24, TimeUnit.HOURS);


        booking.setDoctorId(bookingDto.getDoctoreId());
        booking.setPatientId(bookingDto.getPatientId());

  if(bookingDto.getBookingTime()!=null){
      booking.setBookingTime(bookingDto.getBookingTime());
        bookingRepo.save(booking);
   }
  else
    {
      System.out.println("time slot is not avialable");
    }
    }
}
