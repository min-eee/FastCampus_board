package com.fastcampus.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class FastCampusBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastCampusBoardApplication.class, args);
	}

}
