package com.test.taxservice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressVo {
	
	private int addressId;
	
	private String addresssLine1;
	private String city;
	private String postalCode;

}
