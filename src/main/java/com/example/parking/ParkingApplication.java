package com.example.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingApplication {

	// DB access: http://localhost:8080/h2-console/login.jsp
	// JDBC URL: jdbc:h2:mem:parking
	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
	}

}
