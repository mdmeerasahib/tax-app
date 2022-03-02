package com.test.taxservice.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.test.taxservice.vo.AddressVo;
import com.test.taxservice.vo.CitizenVo;
import com.test.taxservice.vo.TaxPayableVo;
import com.test.taxservice.vo.TaxPayerDetail;

import reactor.core.publisher.Mono;

@Service
public class TaxPayableService {
	
	@Autowired
	private WebClient citizenServiceWebClient;
	
	@Autowired
	private WebClient addressServiceWebClient;
	
	/**
	 * This method retrieves and returns tax payer details for specified financial year
	 * @param finYear - financial year, should be of the format "FY<YY>-<YY>". Example "FY20-21" denoting financial Year 20/21
	 * @return - list of TaxPayerDetail with TaxPayable data
	 */
	public List<TaxPayerDetail> getTaxPayerDataForFy(String finYear) {
		
		final List<TaxPayerDetail> taxPayerDtlList = new ArrayList<>();;
		
		//TODO Replace this with repo fetch from H2
		List<TaxPayableVo> taxPayableList = Arrays.asList(
				new TaxPayableVo("A1B2C3", "FY20-21", BigDecimal.valueOf(2500.00)),
				new TaxPayableVo("D1E2F3", "FY20-21", BigDecimal.valueOf(2000.00)),
				new TaxPayableVo("G1H2I3", "FY20-21", BigDecimal.valueOf(1800.00)),
				new TaxPayableVo("A1B2C3", "FY21-22", BigDecimal.valueOf(800.00)),
				new TaxPayableVo("G1H2I3", "FY21-22", BigDecimal.valueOf(1200.00)));
		
		
		//TODO Revise this when fetching from DB
		Map<String, List<TaxPayableVo>> taxPayableMap = taxPayableList.stream().collect(
				Collectors.groupingBy(TaxPayableVo::getFinYear, Collectors.mapping(Function.identity(), Collectors.toList())));
		
		
		List<TaxPayableVo> taxPayableForFYList = taxPayableMap.get(finYear);
		
		List<String> citizenIdList = taxPayableForFYList.stream().map(TaxPayableVo::getCitizenId).distinct().collect(Collectors.toList());
		
		
		Map<String, CitizenVo> citizenDataMap = retrieveCitizenData(citizenIdList);
		
		
		taxPayableForFYList.forEach(taxPayable -> { 
			
			TaxPayerDetail taxPayerDtl = new TaxPayerDetail(citizenDataMap.get(taxPayable.getCitizenId()),taxPayable);
			taxPayerDtlList.add(taxPayerDtl);
			
		});
		
		return taxPayerDtlList;
		
	}

	/**
	 * Fetches Citizen Data such as Citizen info and address info form citizen-service and address-service respectively
	 * @param citizenIdList - List of unique citizen Ids
	 * @return citizenDataMap - Map with key as Citizen ID and value as CitizenVo
	 */
	private Map<String, CitizenVo> retrieveCitizenData(List<String> citizenIdList) {
		Map<String, CitizenVo> citizenDataMap = new HashMap<>();
		citizenIdList.forEach(citizenId -> { 
			Mono<CitizenVo> citizenVoMono = citizenServiceWebClient.get().uri("/" + citizenId).retrieve().bodyToMono(CitizenVo.class); 
			CitizenVo citizenData = citizenVoMono.block();
			
			Mono<AddressVo> addressVoMono = addressServiceWebClient.get().uri("/" + citizenData.getAddressId()).retrieve().bodyToMono(AddressVo.class); 
			AddressVo addressData = addressVoMono.block();
			
			citizenData.setAddressData(addressData);
			
			citizenDataMap.put(citizenId, citizenData);
		});
		return citizenDataMap;
	}

}
