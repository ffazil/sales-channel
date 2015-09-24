package com.tracebucket.x.saleschannel.domain.command;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Madhavi on 09-09-2015.
 */
public class UpdateSalesChannelCommand {

    @NotNull
    private final String id;

    @NotNull
    private final String name;

    @NotNull
    private final String code;

    @NotNull
    private final String description;

    @NotNull
    private final SalesChannelType channelType;

    private final Date startTime;

    private final Date endTime;

    public UpdateSalesChannelCommand(String id, String name, String code, String description,
                                     SalesChannelType channelType, Date startTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.channelType = channelType;
        this.startTime = startTime;
        this.endTime = endTime;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() { return  code;}

    public String getDescription() { return description;    }

    public SalesChannelType getChannelType(){ return  channelType;}

    public Date getEndTime() { return endTime;  }

    public Date getStartTime() { return startTime;   }
}
