package com.ch.happyhours.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigServer
@SpringBootApplication
public class HappyHoursConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyHoursConfigApplication.class, args);
	}

	@RestController
	public class HelloController {

		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String sayHello() {
			return "Hello from Happy Hours Config ";
		}

	}
}
