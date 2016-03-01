package com.tracebucket.x1.saleschannel.test.builder;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;
import com.tracebucket.x.saleschannel.rest.resource.CreateSalesChannelRequest;
import com.tracebucket.x.saleschannel.rest.resource.SalesChannelAddressRequest;


public class SalesChannelAddressResourceBuilder {

/*
    private String name;
    private String code;
    private String description;
    private SalesChannelType channelType;
*/

    private  String line1;
    private  String line2;
    private  String city;
    private  String state;
    private  String country;
    private  String pincode;
    private  String website;

    private SalesChannelAddressResourceBuilder(){

    }

    public static SalesChannelAddressResourceBuilder asSalesChannelAddress(){
        return new SalesChannelAddressResourceBuilder();
    }



    public SalesChannelAddressResourceBuilder withLine1(String line1){
        this.line1 = line1;
        return this;
    }

    public SalesChannelAddressResourceBuilder withLine2(String line2){
        this.line2 = line2;
        return this;
    }

    public SalesChannelAddressResourceBuilder withCity(String city){
        this.city = city;
        return this;
    }

    public SalesChannelAddressResourceBuilder withState(String state){
        this.state = state;
        return this;
    }

    public SalesChannelAddressResourceBuilder withCountry(String country){
        this.country = country;
        return this;
    }

    public SalesChannelAddressResourceBuilder withPincode(String pincode){
        this.pincode = pincode;
        return this;
    }

    public SalesChannelAddressResourceBuilder withWebsite(String website){
        this.website = website;
        return this;
    }



    public SalesChannelAddressRequest build(){
        SalesChannelAddressRequest salesChannelAddressRequest = new SalesChannelAddressRequest();
        salesChannelAddressRequest.setLine1(line1);
        salesChannelAddressRequest.setLine2(line2);
        salesChannelAddressRequest.setCity(city);
        salesChannelAddressRequest.setState(state);
        salesChannelAddressRequest.setCountry(country);
        salesChannelAddressRequest.setPincode(pincode);
        salesChannelAddressRequest.setWebsite(website);
        return salesChannelAddressRequest;
    }
}