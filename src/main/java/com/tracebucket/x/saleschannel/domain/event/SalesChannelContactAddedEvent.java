package com.tracebucket.x.saleschannel.domain.event;

import com.tracebucket.x.saleschannel.domain.model.Contact;

/**
 * Created by Madhavi on 09-09-2015.
 */
public class SalesChannelContactAddedEvent  {

    private final String name;
    private final String phone;
    private final String email;
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
    }

}
