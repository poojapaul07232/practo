package com.practo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PractoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PractoApplication.class, args);
	}
	@Bean
	public CommandLineRunner init()// init method run only once
	{
		return args -> {
			List<String> availableTimeSlots = new ArrayList<>();
			availableTimeSlots.add("10:15 Am");
			availableTimeSlots.add("11:15 Am");
			availableTimeSlots.add("12:15 Am");
		};

	}


}
