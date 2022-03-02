package com.test.taxservice.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.taxservice.vo.TaxPayableVo;

@RestController
@RequestMapping("/api/tax")
public class TaxController {
	
	
	private List<TaxPayableVo> taxPayableList = Arrays.asList(
			new TaxPayableVo("A1B2C3", "FY20-21", BigDecimal.valueOf(2500.00)),
			new TaxPayableVo("D1E2F3", "FY20-21", BigDecimal.valueOf(2000.00)),
			new TaxPayableVo("G1H2I3", "FY20-21", BigDecimal.valueOf(1800.00)),
			new TaxPayableVo("A1B2C3", "FY21-22", BigDecimal.valueOf(800.00)),
			new TaxPayableVo("G1H2I3", "FY20-21", BigDecimal.valueOf(1200.00)));
	
	@RequestMapping("/{finYear}")
	public List<TaxPayableVo> getTaxPayableForFy(@PathVariable String finYear) {
		
		Map<String, List<TaxPayableVo>> taxPayableMap = taxPayableList.stream().collect(
				Collectors.groupingBy(TaxPayableVo::getFinYear, Collectors.mapping(Function.identity(), Collectors.toList())));
		
		
		return taxPayableMap.get(finYear);
		
	}

}
