package com.test.taxservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class TaxServiceApplication {

	
	@Value("${citizen-service.url}")
	private String citizenServiceUrl;
	
	@Value("${address-service.url}")
	private String addressServiceUrl;
	
	public static void main(String[] args) {
		SpringApplication.run(TaxServiceApplication.class, args);
	}
	
	@Bean
	WebClient citizenServiceWebClient() {
		return WebClient.builder().baseUrl(citizenServiceUrl).build();
	}
	
	@Bean
	WebClient addressServiceWebClient() {
		return WebClient.builder().baseUrl(addressServiceUrl).build();
	}

}
