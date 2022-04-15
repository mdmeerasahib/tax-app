package com.test.taxservice.lb;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient(value = "citizen-info-service")
public class CitizenServiceLB {

	@Bean
	public Feign.Builder citizenFeignBuilder() {
		return Feign.builder();
	}
}
