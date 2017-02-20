package com.phg.looksay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.phg.looksay.dao", "com.phg.looksay.service", "com.phg.looksay.controller"})
public class LooksayApplication {

	public static void main(String[] args) {
		SpringApplication.run(LooksayApplication.class, args);
	}
}
