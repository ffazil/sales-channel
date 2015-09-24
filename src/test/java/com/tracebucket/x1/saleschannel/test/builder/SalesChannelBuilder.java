package com.tracebucket.x1.saleschannel.test.builder;

import com.tracebucket.x.saleschannel.domain.model.SalesChannel;
import com.tracebucket.x.saleschannel.query.model.SalesChannelEntry;
import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;

import java.util.*;

/**
 * Created by sadath on 25-Nov-14.
 */
public class SalesChannelBuilder {

    private String name;
    private String code;
    private String description;
    private SalesChannelType channelType;

    private SalesChannelBuilder(){

    }

    public static SalesChannelBuilder asSalesChannel(){
        return new SalesChannelBuilder();
    }

    public SalesChannelBuilder withName(String name){
        this.name = name;
        return this;
    }

    public SalesChannelBuilder withCode(String code){
        this.code = code;
        return this;
    }

    public SalesChannelBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public SalesChannelBuilder withChannelType(SalesChannelType channelType)
    {
        this.channelType = channelType;
        return this;
    }


    public SalesChannelEntry build(){
        SalesChannelEntry salesChannel = new SalesChannelEntry();
        salesChannel.setName(name);
        salesChannel.setCode(code);
        salesChannel.setDescription(description);
        salesChannel.setChannelType(channelType);
        return salesChannel;
    }
}
