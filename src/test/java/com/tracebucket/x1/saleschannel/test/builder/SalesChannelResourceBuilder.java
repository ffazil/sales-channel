package com.tracebucket.x1.saleschannel.test.builder;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;
import com.tracebucket.x.saleschannel.rest.resource.CreateSalesChannelRequest;

import java.util.*;

/**
 * Created by sadath on 16-Apr-15.
 */
public class SalesChannelResourceBuilder {

    private String name;
    private String code;
    private String description;
    private SalesChannelType channelType;

    private SalesChannelResourceBuilder(){

    }

    public static SalesChannelResourceBuilder asSalesChannel(){
        return new SalesChannelResourceBuilder();
    }

    public SalesChannelResourceBuilder withName(String name){
        this.name = name;
        return this;
    }

    public SalesChannelResourceBuilder withCode(String code){
        this.code = code;
        return this;
    }
    public SalesChannelResourceBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public SalesChannelResourceBuilder withChannelType(SalesChannelType channelType)
    {
        this.channelType = channelType;
        return this;
    }


    public CreateSalesChannelRequest build(){
        CreateSalesChannelRequest salesChannelRequest = new CreateSalesChannelRequest();
        salesChannelRequest.setName(name);
        salesChannelRequest.setCode(code);
        salesChannelRequest.setDescription(description);
        salesChannelRequest.setChannelType(channelType);
        return salesChannelRequest;
    }
}