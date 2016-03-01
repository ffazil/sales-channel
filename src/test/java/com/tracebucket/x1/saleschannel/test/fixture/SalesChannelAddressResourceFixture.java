package com.tracebucket.x1.saleschannel.test.fixture;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;
import com.tracebucket.x.saleschannel.rest.resource.CreateSalesChannelRequest;
import com.tracebucket.x.saleschannel.rest.resource.SalesChannelAddressRequest;
import com.tracebucket.x1.saleschannel.test.builder.SalesChannelAddressResourceBuilder;
import com.tracebucket.x1.saleschannel.test.builder.SalesChannelResourceBuilder;

/**
 * Created by sadath on 16-Apr-15.
 */
public class SalesChannelAddressResourceFixture {
    public static SalesChannelAddressRequest standardSalesChannelAddress(){
        SalesChannelAddressRequest salesChannelAddressRequest = SalesChannelAddressResourceBuilder.asSalesChannelAddress()
                .withLine1("Line1")
                .withLine2("Line2")
                .withCity("City")
                .withState("State")
                .withCountry("Country")
                .withPincode("560009")
                .withWebsite("Test@test.com")
                .build();
        return salesChannelAddressRequest;
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