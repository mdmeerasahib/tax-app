package com.test.taxservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.taxservice.vo.CitizenVo;

@FeignClient(value = "CITIZEN-INFO-SERVICE")
public interface CitizenFeignClient {
	
	@GetMapping("/api/citizen/{citizenId}")
	public CitizenVo getCitizenData(@PathVariable("citizenId") String citizenId);

}
