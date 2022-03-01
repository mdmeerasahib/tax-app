package com.test.addressservice.controller;

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

import com.test.addressservice.vo.AddressVo;

@RestController
@RequestMapping(value = "/api/address")
public class AddressController {

	private List<AddressVo> addressList = Arrays.asList(new AddressVo(1, "10 Downing St", "London", "123456"),
			new AddressVo(2, "1 Parliament House", "New Delhi", "120000"),
			new AddressVo(3, "2 Hobbiton", "Shire", "310000"));

	@GetMapping("/{addressId}")
	public AddressVo getAddress(@PathVariable Integer addressId) {
		
		Map<Integer, AddressVo> addressMap = 
				 addressList.stream()
				 .sorted(Comparator.comparingInt(AddressVo::getAddressId).reversed())
				 .collect(
						 Collectors.toMap(AddressVo::getAddressId, Function.identity(), (oldVal,newVal) -> newVal, LinkedHashMap::new));
		 
		return addressMap.get(addressId);
	
	}

}
