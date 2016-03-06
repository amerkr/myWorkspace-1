package myPackage;

import java.util.ArrayList;
import java.util.List;

public class SampleBoResponse {

	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Sample> getFeeOverrideList() {
		if(null == feeOverrideList){
			feeOverrideList = new ArrayList<Sample>();
		}
		return feeOverrideList;
	}
	public void setFeeOverrideList(List<Sample> feeOverrideList) {
		this.feeOverrideList = feeOverrideList;
	}
	private String message;
	private List<Sample> feeOverrideList;
	
}
