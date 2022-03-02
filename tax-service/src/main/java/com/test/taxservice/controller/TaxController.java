package com.test.taxservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.taxservice.service.TaxPayableService;
import com.test.taxservice.vo.TaxPayerDetail;

@RestController
@RequestMapping("/api/tax")
public class TaxController {
	
	@Autowired
	private TaxPayableService taxPayableSvc;
	
	@RequestMapping("/{finYear}")
	public List<TaxPayerDetail> getTaxPayableForFy(@PathVariable String finYear) {
		
		return taxPayableSvc.getTaxPayerDataForFy(finYear);
		
	}

}
