package com.tracebucket.x.saleschannel.rest.resource;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;

import javax.validation.constraints.NotNull;

public class SalesChannelAddressRequest {



	//@NotNull
	private String salesChannelId ;

	@NotNull
	private String line1;

	@NotNull
	private String line2;

	@NotNull
	private String city;

	private String state;

	private String country;

	private String pincode;

	private String website;


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getSalesChannelId() {
		return salesChannelId;
	}

	public void setSalesChannelId(String salesChannelId) {
		this.salesChannelId = salesChannelId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}


}
