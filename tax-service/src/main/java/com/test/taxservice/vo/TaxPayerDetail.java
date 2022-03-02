package com.test.taxservice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TaxPayerDetail {
	
	private CitizenVo citizenInfo;
	
	private TaxPayableVo taxPayable;

}
