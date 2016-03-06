package myPackage;

import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;



public class SampleBoImpl {
public static void main(String[] args) throws Exception {
	
	SampleBoRequest boRequest = new SampleBoRequest();
	List<Sample> feeOverrideList = null;
	SampleBoResponse boResponse = null;
	
	boRequest.setAsOfDate("2018");
	
	boRequest.setProviderId("");
	boRequest.setCarrierId("");
	boRequest.setListId("");
	
	boRequest.setNetworkServiceType("");
	boRequest.setState("");
	
	boRequest.setRateType("");
	boRequest.setSubType("");
	
	boRequest.setFeeDispeningFeeType("B");
	boRequest.setFeeOverrideType("");
	
	Validator validate = new Validator();
	validate.validateFeeOverride(boRequest);
	
	if(null != boRequest.getProviderId()){
		
		
		if(boRequest.getFeeOverrideType().equals("D")){
			feeOverrideList =  fetchFromDispenseTable(boRequest);
			
		}else if(boRequest.getFeeOverrideType().equals("T")){
			feeOverrideList =   fetchFromTransactionTable(boRequest);
			 
		}else if(boRequest.getFeeOverrideType().equals("C")){
			feeOverrideList =   fetchFromCompoundTable(boRequest);
			
		}else if(boRequest.getFeeOverrideType().equals("V")){
			feeOverrideList =   fetchFromVaccineTable(boRequest);
			
		}else{
			feeOverrideList =   fetchFromAllTable(boRequest);
		}
		
		
		if(!CollectionUtils.isEmpty(feeOverrideList)){
			boResponse = new SampleBoResponse();
			boResponse.setCode("500");
			boResponse.setMessage("huccess");
			boResponse.setFeeOverrideList(feeOverrideList);
			
		
			System.out.println("Game over");
			
		}else{
			System.out.println("not found bro");
			throw new NotFound();
		}
		
		
		
	}else{
		
		System.out.println("not found bro");
		throw new NotFound();
	
	}
	
	
}



private static List<Sample> fetchFromVaccineTable(
		SampleBoRequest boRequest) {
	
	List<Sample> feeOverrideList = dumpValue(boRequest);
	
	return feeOverrideList;
}

private static List<Sample> fetchFromCompoundTable(
		SampleBoRequest boRequest) {
	List<Sample> feeOverrideList = dumpValue(boRequest);
	return feeOverrideList;
}

private static List<Sample> fetchFromTransactionTable(
		SampleBoRequest boRequest) {
	List<Sample> feeOverrideList = null;
	if(StringUtils.isEmpty(boRequest.getListId())){
       feeOverrideList = dumpValue(boRequest);
	}
	return feeOverrideList;
}

private static List<Sample> fetchFromDispenseTable(
		SampleBoRequest boRequest) {
	List<Sample> feeOverrideList = null;
	if(StringUtils.isEmpty(boRequest.getListId())){
	feeOverrideList = dumpValue(boRequest);
	}
	return feeOverrideList;
}

private static List<Sample> fetchFromAllTable(
		SampleBoRequest boRequest) {
	List<Sample> feeOverrideList = new ArrayList<Sample>();
	
	
	
	if(null != fetchFromDispenseTable(boRequest)){
		feeOverrideList.addAll(fetchFromDispenseTable(boRequest));
	}
	
	if(null != fetchFromTransactionTable(boRequest)){
		feeOverrideList.addAll(fetchFromTransactionTable(boRequest));
	}
	
	if(null != fetchFromCompoundTable(boRequest)){
		feeOverrideList.addAll(fetchFromCompoundTable(boRequest));
	}
	
	if(null != fetchFromVaccineTable(boRequest)){
		feeOverrideList.addAll(fetchFromVaccineTable(boRequest));
	}
	
	
	return feeOverrideList;
}

private static List<Sample> dumpValue(SampleBoRequest boRequest) {
	List<Sample> feeOverrideList = new ArrayList<Sample>();
	Sample override = new Sample();
	override.setCarrierId("cc");
	override.setClaimType("cc");
	feeOverrideList.add(override);
	return feeOverrideList;
}
	
}

