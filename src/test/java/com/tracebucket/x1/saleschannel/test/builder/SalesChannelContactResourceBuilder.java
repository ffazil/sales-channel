package com.tracebucket.x1.saleschannel.test.builder;

import com.tracebucket.x.saleschannel.rest.resource.SalesChannelAddressRequest;
import com.tracebucket.x.saleschannel.rest.resource.SalesChannelContactRequest;

import java.util.Date;


public class SalesChannelContactResourceBuilder {


    private String name;
    private String phone;
    private String email;
    private Date workTimeFrom;
    private Date workTimeTo;
    private String mobile;
    private String fax;

    private SalesChannelContactResourceBuilder(){

    }

    public static SalesChannelContactResourceBuilder asSalesChannelContact(){
        return new SalesChannelContactResourceBuilder();
    }



    public SalesChannelContactResourceBuilder withName(String name){
        this.name = name;
        return this;
    }

    public SalesChannelContactResourceBuilder withPhone(String phone){
        this.phone = phone;
        return this;
    }

    public SalesChannelContactResourceBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public SalesChannelContactResourceBuilder withMobile(String mobile){
        this.mobile = mobile;
        return this;
    }

    public SalesChannelContactResourceBuilder withFax(String fax){
        this.fax = fax;
        return this;
    }

    public SalesChannelContactResourceBuilder withWorkTimeFrom(Date workTimeFrom){
        this.workTimeFrom = workTimeFrom;
        return this;
    }

    public SalesChannelContactResourceBuilder withWorkTimeTo(Date workTimeTo){
        this.workTimeTo = workTimeTo;
        return this;
    }



    public SalesChannelContactRequest build(){
        SalesChannelContactRequest salesChannelContactRequest = new SalesChannelContactRequest();
        salesChannelContactRequest.setName(name);
        salesChannelContactRequest.setPhone(phone);
        salesChannelContactRequest.setEmail(email);
        salesChannelContactRequest.setMobile(mobile);
        salesChannelContactRequest.setFax(fax);
        salesChannelContactRequest.setWorkTimeFrom(workTimeFrom);
        salesChannelContactRequest.setWorkTimeTo(workTimeTo);
        return salesChannelContactRequest;
    }
}