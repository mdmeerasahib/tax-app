package com.test.taxservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.taxservice.vo.CitizenVo;

@FeignClient(url = "${citizen-service.url}", name = "citizenFeignClient")
public interface CitizenFeignClient {
	
	@GetMapping("/{citizenId}")
	public CitizenVo getCitizenData(@PathVariable("citizenId") String citizenId);

}
