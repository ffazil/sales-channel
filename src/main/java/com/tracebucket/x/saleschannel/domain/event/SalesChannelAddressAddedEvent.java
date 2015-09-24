package com.tracebucket.x.saleschannel.domain.event;

import com.tracebucket.x.saleschannel.domain.model.Address;

/**
 * Created by Madhavi on 09-09-2015.
 */
public class SalesChannelAddressAddedEvent {

    private final String line1;
    private final String line2;
    private final String city;
    private final String state;
    private final String country;
    private final String pincode;
    private final String website;
    private final String salesChannelId;

    public SalesChannelAddressAddedEvent(String salesChannelId,Address address) {
        this.salesChannelId = salesChannelId;
        this.line1 = address.getLine1();
        this.line2 = address.getLine2();
        this.city = address.getCity();
        this.state = address.getState();
        this.country = address.getCountry();
        this.pincode = address.getPincode();
        this.website = address.getWebsite();
    }


    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getWebsite() { return  website;}

    public String getPincode() { return pincode;    }

    public String getSalesChannelId() { return salesChannelId; }
}
