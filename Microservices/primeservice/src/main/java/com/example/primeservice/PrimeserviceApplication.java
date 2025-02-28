package com.example.primeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PrimeserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeserviceApplication.class, args);
	}

}
