package com.tracebucket.x.saleschannel.domain.event;

import com.tracebucket.x.saleschannel.domain.model.Contact;

import java.util.Date;

/**
 * Created by Madhavi on 09-09-2015.
 */
public class SalesChannelContactAddedEvent  {

    private final String name;
    private final String phone;
    private final String email;
    private final Date workTimeFrom;
    private final Date workTimeTo;
    private final String mobile;
    private final String fax;
    private final String salesChannelId;

    public SalesChannelContactAddedEvent(String salesChannelId,Contact contact) {
        this.salesChannelId = salesChannelId;
        this.name = contact.getName();
        this.phone = contact.getPhone();
        this.email = contact.getEmail();
        this.mobile = contact.getMobile();
        this.fax = contact.getFax();
        this.workTimeFrom = contact.getWorkTimeFrom();
        this.workTimeTo = contact.getWorkTimeTo();
    }

    public String getEmail() {
        return email;
    }

    public String getFax() {
        return fax;
    }

    public String getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getSalesChannelId() {
        return salesChannelId;
    }

    public Date getWorkTimeFrom() {
        return workTimeFrom;
    }

    public Date getWorkTimeTo() {
        return workTimeTo;
    }
}
