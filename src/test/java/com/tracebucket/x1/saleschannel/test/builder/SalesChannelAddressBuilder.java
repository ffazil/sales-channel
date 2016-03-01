package com.tracebucket.x1.saleschannel.test.builder;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;
import com.tracebucket.x.saleschannel.query.model.AddressEntry;
import com.tracebucket.x.saleschannel.query.model.SalesChannelEntry;


public class SalesChannelAddressBuilder {

    private  String line1;
    private  String line2;
    private  String city;
    private  String state;
    private  String country;
    private  String pincode;
    private  String website;

    private SalesChannelAddressBuilder(){

    }

    public static SalesChannelAddressBuilder asSalesChannelAddress(){
        return new SalesChannelAddressBuilder();
    }

    public SalesChannelAddressBuilder withLine1(String line1){
        this.line1 = line1;
        return this;
    }

    public SalesChannelAddressBuilder withLine2(String line2){
        this.line2 = line2;
        return this;
    }

    public SalesChannelAddressBuilder withCity(String city){
        this.city = city;
        return this;
    }

    public SalesChannelAddressBuilder withState(String state){
        this.state = state;
        return this;
    }

    public SalesChannelAddressBuilder withCountry(String country){
        this.country = country;
        return this;
    }

    public SalesChannelAddressBuilder withPincode(String pincode){
        this.pincode = pincode;
        return this;
    }

    public SalesChannelAddressBuilder withWebsite(String website){
        this.website = website;
        return this;
    }

    public AddressEntry build(){
        AddressEntry salesChannelAddress = new AddressEntry();
        salesChannelAddress.setLine1(line1);
        salesChannelAddress.setLine2(line2);
        salesChannelAddress.setCity(city);
        salesChannelAddress.setState(state);
        salesChannelAddress.setCountry(country);
        salesChannelAddress.setPincode(pincode);
        salesChannelAddress.setWebsite(website);
        return salesChannelAddress;
    }
}
