package com.test.citizenservice.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.citizenservice.vo.CitizenVo;

@RestController
@RequestMapping("/api/citizen")
public class CitizenController {
	
	private List<CitizenVo> citizenList = Arrays.asList(new CitizenVo("A1B2C3","Meerasahib","Mowzoon",1),
			new CitizenVo("D1E2F3","John","Doe",2),
			new CitizenVo("G1H2I3","Roman","Abramovich",3));

	
	@GetMapping("/{citizenId}")
	public CitizenVo getCitizenData(@PathVariable("citizenId") String citizenId) {
		
		Map<String, CitizenVo> citizenMap = citizenList.stream().sorted(Comparator.comparing(CitizenVo::getCitizenId))
		 .collect(
				 Collectors.toMap(CitizenVo::getCitizenId, Function.identity(),(oldVal, newVal) -> oldVal, LinkedHashMap::new));
		
		
		return citizenMap.get(citizenId);
		
	}
}
