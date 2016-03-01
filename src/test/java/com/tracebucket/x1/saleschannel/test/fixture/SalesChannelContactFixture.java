package com.tracebucket.x1.saleschannel.test.fixture;

import com.tracebucket.x.saleschannel.query.model.AddressEntry;
import com.tracebucket.x.saleschannel.query.model.ContactEntry;
import com.tracebucket.x1.saleschannel.test.builder.SalesChannelAddressBuilder;
import com.tracebucket.x1.saleschannel.test.builder.SalesChannelContactBuilder;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class SalesChannelContactFixture {

    public static ContactEntry standardSalesChannelContact(){
        ContactEntry salesChannelContact= SalesChannelContactBuilder.asSalesChannelContact()
                .withEmail("test@abc.com")
                .build();
        return salesChannelContact;
    }

    public static ContactEntry standardSalesChannelContact2(){
        Long hours = 10l;
        java.time.Instant fromTime = Instant.now();
        java.time.Instant toTime = Instant.now().plus(Duration.ofHours(10l));
        ContactEntry salesChannelContact = SalesChannelContactBuilder.asSalesChannelContact()
                .withName("Test")
                .withEmail("test@abc.com")
                .withPhone("11112")
                .withMobile("11123")
                .withFax("11134")
                .withWorkTimeFrom(Date.from(fromTime))
                .withWorkTimeTo(Date.from(toTime))
                .build();
        return salesChannelContact;
    }
}
