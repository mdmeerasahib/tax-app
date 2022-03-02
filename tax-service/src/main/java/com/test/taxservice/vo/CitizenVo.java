package com.test.taxservice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CitizenVo {
	
	private String citizenId;
	
	private String firstName;
	private String lastName;
	
	private int addressId;
	
	private AddressVo addressData;

}
