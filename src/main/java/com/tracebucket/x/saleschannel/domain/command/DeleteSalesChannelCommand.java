package com.tracebucket.x.saleschannel.domain.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class DeleteSalesChannelCommand {

	@TargetAggregateIdentifier
	private final String id;

    public DeleteSalesChannelCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
