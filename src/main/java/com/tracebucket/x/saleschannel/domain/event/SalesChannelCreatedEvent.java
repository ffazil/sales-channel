package com.tracebucket.x.saleschannel.domain.event;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;

/**
 * Created by Madhavi on 09-09-2015.
 */
public class SalesChannelCreatedEvent implements SalesChannelEvent {

    private final String id;
    private final String name;
    private final String description;
    private final SalesChannelType channelType;

    public SalesChannelCreatedEvent(String id, String name, String description, SalesChannelType channelType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.channelType = channelType;
    }

    @Override
    public String getId() {
        return id;
    }

    public SalesChannelType getChannelType() {
        return channelType;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
