package com.tracebucket.x.saleschannel.rest.resource;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreateSalesChannelRequest {



	//@NotNull
	private String id ;

	@NotNull
	private String name;

	@NotNull
	private String code;

	@NotNull
	private String description;

	@NotNull
	private SalesChannelType channelType;

	private Date startTime;

	private Date endTime;

	public SalesChannelType getChannelType() {
		return channelType;
	}

	public void setChannelType(SalesChannelType channelType) {
		this.channelType = channelType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() { return code;	}

	public void setCode(String code) {	this.code = code;	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getEndTime() { return endTime;	}

	public void setEndTime(Date endTime) { this.endTime = endTime;	}

	public Date getStartTime() { return startTime;	}

	public void setStartTime(Date startTime) { this.startTime = startTime;	}
}
