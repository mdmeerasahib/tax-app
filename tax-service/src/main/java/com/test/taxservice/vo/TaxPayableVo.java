package com.test.taxservice.vo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class TaxPayableVo {
	
	private String citizenId;
	
	private String finYear;
	private BigDecimal taxPayable;

}
