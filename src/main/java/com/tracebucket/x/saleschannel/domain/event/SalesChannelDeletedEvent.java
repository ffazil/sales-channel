package com.tracebucket.x.saleschannel.domain.event;

public class SalesChannelDeletedEvent implements SalesChannelEvent {

	private final String id;

    public SalesChannelDeletedEvent(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
