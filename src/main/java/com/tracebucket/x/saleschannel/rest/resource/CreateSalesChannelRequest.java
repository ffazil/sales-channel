package com.tracebucket.x.saleschannel.rest.resource;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;

import javax.validation.constraints.NotNull;

public class CreateSalesChannelRequest {
	
	@NotNull
	private String name;

	@NotNull
	private String description;

	@NotNull
	private SalesChannelType channelType;

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
}
