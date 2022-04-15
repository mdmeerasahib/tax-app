package com.test.taxservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.taxservice.vo.AddressVo;

@FeignClient(url = "${address-service.url}", name = "addressFeignClient")
public interface AddressFeignClient {
	
	@GetMapping("/{addressId}")
	public AddressVo getAddress(@PathVariable Integer addressId);

}
