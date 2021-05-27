package com.example.demandas.demandas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.demandas.demandas.demands","com.example.demandas.demandas.serviceType"})
public class DemandasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemandasApplication.class, args);
	}

}
