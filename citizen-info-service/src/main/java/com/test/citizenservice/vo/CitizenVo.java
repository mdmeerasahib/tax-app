package com.test.citizenservice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CitizenVo {
	
	private String citizenId;
	
	private String firstName;
	private String lastName;
	
	private int addressId;

}
