package com.test.taxservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.taxservice.vo.AddressVo;

@FeignClient(value = "ADDRESS-SERVICE")
public interface AddressFeignClient {
	
	@GetMapping("/api/address/{addressId}")
	public AddressVo getAddress(@PathVariable Integer addressId);

}
