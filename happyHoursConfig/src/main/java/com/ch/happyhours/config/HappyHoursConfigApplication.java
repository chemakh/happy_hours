package com.ch.happyhours.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HappyHoursConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyHoursConfigApplication.class, args);
	}
}
