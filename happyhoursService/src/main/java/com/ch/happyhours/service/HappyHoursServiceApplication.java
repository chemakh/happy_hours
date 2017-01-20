package com.ch.happyhours.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@ComponentScan("com.ch.happyhours.service")
@EnableFeignClients
@EnableWebSocketMessageBroker
@EnableHystrix
//@EnableHystrixDashboard
@EnableJpaRepositories("com.ch.happyhours.service.repository")
@SpringBootApplication
public class HappyHoursServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyHoursServiceApplication.class, args);
	}
}
