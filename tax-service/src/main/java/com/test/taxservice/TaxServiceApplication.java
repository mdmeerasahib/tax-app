package com.test.taxservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.test.taxservice.feignclients"})
public class TaxServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(TaxServiceApplication.class, args);
	}
	

}
