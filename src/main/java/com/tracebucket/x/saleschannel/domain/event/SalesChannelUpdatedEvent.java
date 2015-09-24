package com.tracebucket.x.saleschannel.domain.event;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;

/**
 * Created by Madhavi on 09-09-2015.
 */
public class SalesChannelUpdatedEvent implements SalesChannelEvent {

    private final String id;
    private final String name;
    private final String code;
    private final String description;
    private final SalesChannelType channelType;

    public SalesChannelUpdatedEvent(String id, String name, String code, String description, SalesChannelType channelType) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.channelType = channelType;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getId() {
        return id;
    }

    public SalesChannelType getChannelType() {
        return channelType;
    }

    public String getName() {
        return name;
    }

    public  String getCode(){ return  code;}
}
