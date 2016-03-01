package com.tracebucket.x1.saleschannel.test.builder;

import com.tracebucket.x.saleschannel.query.model.AddressEntry;
import com.tracebucket.x.saleschannel.query.model.ContactEntry;

import java.util.Date;


public class SalesChannelContactBuilder {

    private String name;
    private String phone;
    private String email;
    private Date workTimeFrom;
    private Date workTimeTo;
    private String mobile;
    private String fax;


    private SalesChannelContactBuilder(){

    }

    public static SalesChannelContactBuilder asSalesChannelContact(){
        return new SalesChannelContactBuilder();
    }

    public SalesChannelContactBuilder withName(String name){
        this.name = name;
        return this;
    }

    public SalesChannelContactBuilder withPhone(String phone){
        this.phone = phone;
        return this;
    }

    public SalesChannelContactBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public SalesChannelContactBuilder withMobile(String mobile){
        this.mobile = mobile;
        return this;
    }

    public SalesChannelContactBuilder withFax(String fax){
        this.fax = fax;
        return this;
    }

    public SalesChannelContactBuilder withWorkTimeFrom(Date workTimeFrom){
        this.workTimeFrom = workTimeFrom;
        return this;
    }

    public SalesChannelContactBuilder withWorkTimeTo(Date workTimeTo){
        this.workTimeTo = workTimeTo;
        return this;
    }

    public ContactEntry build(){
        ContactEntry salesChannelContact = new ContactEntry();
        salesChannelContact.setName(name);
        salesChannelContact.setPhone(phone);
        salesChannelContact.setEmail(email);
        salesChannelContact.setMobile(mobile);
        salesChannelContact.setFax(fax);
        salesChannelContact.setWorkTimeFrom(workTimeFrom);
        salesChannelContact.setWorkTimeTo(workTimeTo);
        return salesChannelContact;
    }
}
