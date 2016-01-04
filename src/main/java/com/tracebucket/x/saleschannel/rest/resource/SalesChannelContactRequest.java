package com.tracebucket.x.saleschannel.rest.resource;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SalesChannelContactRequest {



	//@NotNull
	private String salesChannelId ;

	@NotNull
	private String name;

	@NotNull
	private String phone;

	@NotNull
	private String email;

	private String mobile;

	private String fax;

	private Date workTimeFrom;

	private Date workTimeTo;


	public String getEmail() { return email;	}

	public void setEmail(String email) { this.email = email;	}

	public String getFax() { return fax;	}

	public void setFax(String fax) {	this.fax = fax;	}

	public String getMobile() {		return mobile;	}

	public void setMobile(String mobile) {	this.mobile = mobile;	}

	public String getName() {	return name;	}

	public void setName(String name) {	this.name = name;	}

	public String getPhone() {	return phone;	}

	public void setPhone(String phone) { this.phone = phone;	}

	public String getSalesChannelId() {	return salesChannelId;	}

	public void setSalesChannelId(String salesChannelId) {	this.salesChannelId = salesChannelId;	}

	public Date getWorkTimeFrom() {	return workTimeFrom;	}

	public void setWorkTimeFrom(Date workTimeFrom) { this.workTimeFrom = workTimeFrom;	}

	public Date getWorkTimeTo() { return workTimeTo;	}

	public void setWorkTimeTo(Date workTimeTo) {  this.workTimeTo = workTimeTo;	}

}
