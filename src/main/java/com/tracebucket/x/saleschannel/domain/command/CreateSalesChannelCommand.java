package com.tracebucket.x.saleschannel.domain.command;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;

import javax.validation.constraints.NotNull;

/**
 * Created by Madhavi on 09-09-2015.
 */
public class CreateSalesChannelCommand {

    @NotNull
    private final String id;

    @NotNull
    private final String name;

    @NotNull
    private final String description;

    @NotNull
    private final SalesChannelType channelType;

    public CreateSalesChannelCommand(String id, String name, String description, SalesChannelType channelType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.channelType = channelType;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() { return description;    }

    public SalesChannelType getChannelType(){ return  channelType;}
}
