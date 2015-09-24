package com.tracebucket.x.saleschannel.domain.event;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;

import java.util.Date;

/**
 * Created by Madhavi on 09-09-2015.
 */
public class SalesChannelCreatedEvent implements SalesChannelEvent {

    private final String id;
    private final String name;
    private final String code;
    private final String description;
    private final SalesChannelType channelType;
    private final Date startTime;
    private final Date endTime;

    public SalesChannelCreatedEvent(String id, String name, String code, String description,
                                    SalesChannelType channelType, Date startTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.channelType = channelType;
        this.startTime = startTime;
        this.endTime = endTime;

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

    public  String getCode(){ return  code;}

    public Date getEndTime() { return endTime; }

    public Date getStartTime() { return startTime;  }
}
