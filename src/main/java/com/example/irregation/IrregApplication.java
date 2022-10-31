package com.example.irregation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IrregApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrregApplication.class, args);
	}

}
