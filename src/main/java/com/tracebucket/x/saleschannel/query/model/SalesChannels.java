package com.tracebucket.x.saleschannel.query.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Madhavi on 20-11-2015.
 */
public class SalesChannels {

    @JsonProperty("saleschannels")
    private List<SalesChannelEntry> salesChannels;

    public List<SalesChannelEntry> getSalesChannels() {
        return salesChannels;
    }

    public void setSalesChannels(List<SalesChannelEntry> salesChannels) {
        this.salesChannels = salesChannels;
    }
}
