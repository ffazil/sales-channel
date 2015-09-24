package com.tracebucket.x1.saleschannel.test.fixture;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;
import com.tracebucket.x.saleschannel.rest.resource.CreateSalesChannelRequest;
import com.tracebucket.x1.saleschannel.test.builder.SalesChannelResourceBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sadath on 16-Apr-15.
 */
public class SalesChannelResourceFixture {
    public static CreateSalesChannelRequest standardSalesChannel(){
        CreateSalesChannelRequest salesChannelRequest = SalesChannelResourceBuilder.asSalesChannel()
                .withName("Catalogue3")
                .withCode("Code3")
                .withDescription("The third Catalogue")
                .withChannelType(SalesChannelType.CATALOGUE)
                .build();
        return salesChannelRequest;
    }

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