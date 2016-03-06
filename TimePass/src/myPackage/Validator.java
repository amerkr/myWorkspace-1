package myPackage;

import org.springframework.util.StringUtils;


public class Validator {


	public void validateFeeOverride(SampleBoRequest boRequest) throws Exception{
		
		if(!StringUtils.isEmpty(boRequest.getAsOfDate())){
			
		
		if(StringUtils.isEmpty(boRequest.getProviderId()) && StringUtils.isEmpty(boRequest.getCarrierId()) && 
				StringUtils.isEmpty(boRequest.getListId())&& StringUtils.isEmpty(boRequest.getNetworkServiceType()) &&
				StringUtils.isEmpty(boRequest.getState()) && StringUtils.isEmpty(boRequest.getRateType()) &&
				StringUtils.isEmpty(boRequest.getFeeDispeningFeeType())){
			throw new IllegalArgumentException("At least provide some paramter");
		}
		 
		
		
		if(!StringUtils.isEmpty(boRequest.getRateType())){
            if(StringUtils.isEmpty(boRequest.getFeeOverrideType())){
            boRequest.setFeeOverrideType("D");
                               }
           }

		if(!StringUtils.isEmpty(boRequest.getFeeDispeningFeeType())){
            if(StringUtils.isEmpty(boRequest.getFeeOverrideType())){
            boRequest.setFeeOverrideType("D");
                               }
           }
		if(!StringUtils.isEmpty(boRequest.getProviderId())){
		        boRequest.setProviderId("");//providerDao.getProgeagn(providerId);	
		}
		
		
		
		
		}else{
			throw new IllegalArgumentException("Date is empty");
		
		}
		
	}
	
}
