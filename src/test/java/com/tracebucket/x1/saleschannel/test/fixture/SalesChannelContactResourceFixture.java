package com.tracebucket.x1.saleschannel.test.fixture;

import com.tracebucket.x.saleschannel.query.model.ContactEntry;
import com.tracebucket.x.saleschannel.rest.resource.SalesChannelAddressRequest;
import com.tracebucket.x.saleschannel.rest.resource.SalesChannelContactRequest;
import com.tracebucket.x1.saleschannel.test.builder.SalesChannelAddressResourceBuilder;
import com.tracebucket.x1.saleschannel.test.builder.SalesChannelContactBuilder;
import com.tracebucket.x1.saleschannel.test.builder.SalesChannelContactResourceBuilder;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * Created by sadath on 16-Apr-15.
 */
public class SalesChannelContactResourceFixture {
    public static SalesChannelContactRequest standardSalesChannelContact(){


        Long hours = 10l;
        java.time.Instant fromTime = Instant.now();
        java.time.Instant toTime = Instant.now().plus(Duration.ofHours(10l));
        SalesChannelContactRequest salesChannelContact = SalesChannelContactResourceBuilder.asSalesChannelContact()
                .withName("Test")
                .withEmail("test@abc.com")
                .withPhone("11112")
                .withMobile("11123")
                .withFax("11134")
                .withWorkTimeFrom(Date.from(fromTime))
                .withWorkTimeTo(Date.from(toTime))
               .build();
        return  salesChannelContact;
    }

/*
    public static CreateSalesChannelRequest standardSalesChannel2(){
        CreateSalesChannelRequest salesChannelRequest = SalesChannelResourceBuilder.asSalesChannel()
                .withName("Catalogue4")
                .withCode("Code4")
                .withDescription("The FOurth Catalogue")
                .withChannelType(SalesChannelType.CATALOGUE)
                .build();
        return salesChannelRequest;
    }

    public static CreateSalesChannelRequest standardSalesChannel5(){
        CreateSalesChannelRequest salesChannelRequest = SalesChannelResourceBuilder.asSalesChannel()
                .withName("Catalogue5")
                .withCode("Code5")
                .withDescription("The Fifth Catalogue")
                .withChannelType(SalesChannelType.CATALOGUE)
                .build();
        return salesChannelRequest;
    }
*/

/*
    public static DefaultPersonResource standardPerson2(){
        Map<String, EmailType> emails = new HashMap<String, EmailType>();
        emails.put("firoz@mmp.com", EmailType.PERSONAL);
        Map<String, PhoneType> phones = new HashMap<String, PhoneType>();
        phones.put("23232323232", PhoneType.MOBILE);
        DefaultPersonResource person = DefaultPersonResourceBuilder.asPerson()
                .withFirstName("Firoz")
                .withLastName("Fazil")
                .withGender(Gender.MALE)
                .withBirthDay(new Date())
                .withImage("Image")
                .withEmails(emails)
                .withPhones(phones)
                .build();
        return person;
    }
*/
}