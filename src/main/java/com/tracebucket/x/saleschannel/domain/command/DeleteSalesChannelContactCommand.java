package com.tracebucket.x.saleschannel.domain.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class DeleteSalesChannelContactCommand {

	@TargetAggregateIdentifier
	private final String id;

    public DeleteSalesChannelContactCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
