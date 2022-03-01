package com.test.addressservice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AddressVo {
	
	private int addressId;
	
	private String addresssLine1;
	private String city;
	private String postalCode;

}
