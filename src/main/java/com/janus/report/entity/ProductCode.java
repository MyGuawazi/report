package com.janus.report.entity;
/**
*
*
*@author ZWB
*@date 2019年12月12日
*@version 1.0  
*/
public class ProductCode {
	
	private String masterProductCode;
	private String derekProductCode;
	
	public String getMasterProductCode() {
		return masterProductCode;
	}
	public void setMasterProductCode(String masterProductCode) {
		this.masterProductCode = masterProductCode;
	}
	public String getDerekProductCode() {
		return derekProductCode;
	}
	public void setDerekProductCode(String derekProductCode) {
		this.derekProductCode = derekProductCode;
	}
	
	public ProductCode() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductCode(String masterProductCode, String derekProductCode) {
		this.masterProductCode = masterProductCode;
		this.derekProductCode = derekProductCode;
	}
	
	
	@Override
	public String toString() {
		return "ProductCode [masterProductCode=" + masterProductCode + ", derekProductCode=" + derekProductCode + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((derekProductCode == null) ? 0 : derekProductCode.hashCode());
		result = prime * result + ((masterProductCode == null) ? 0 : masterProductCode.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCode other = (ProductCode) obj;
		if (derekProductCode == null) {
			if (other.derekProductCode != null)
				return false;
		} else if (!derekProductCode.equals(other.derekProductCode))
			return false;
		if (masterProductCode == null) {
			if (other.masterProductCode != null)
				return false;
		} else if (!masterProductCode.equals(other.masterProductCode))
			return false;
		return true;
	}

}
