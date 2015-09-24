package com.tracebucket.x.saleschannel.domain.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class DeleteSalesChannelAddressCommand {

	@TargetAggregateIdentifier
	private final String id;

    public DeleteSalesChannelAddressCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
