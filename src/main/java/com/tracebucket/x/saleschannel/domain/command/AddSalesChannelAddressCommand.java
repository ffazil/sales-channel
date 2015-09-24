package com.tracebucket.x.saleschannel.domain.command;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;

import javax.validation.constraints.NotNull;

/**
 * Created by Madhavi on 09-09-2015.
 */
public class AddSalesChannelAddressCommand {

 @NotNull
 private final String salesChannelid;

 @NotNull
 private  String line1;

 private  String line2;

 @NotNull
 private  String city;

 @NotNull
 private  String state;

 @NotNull
 private  String country;

 @NotNull
 private  String pincode;

 private  String website;

 public AddSalesChannelAddressCommand(String salesChannelid, String line1, String line2, String city, String state, String country,
                                         String pincode, String website) {
        this.salesChannelid = salesChannelid;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.website = website;
    }

    public String getSalesChannelid() {
        return salesChannelid;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getCity() {return city;    }

    public String getPincode() { return pincode;    }

    public String getWebsite() {
        return website;
    }

    public  String getState(){ return state; }

    public  String getCountry() { return country; }

}
