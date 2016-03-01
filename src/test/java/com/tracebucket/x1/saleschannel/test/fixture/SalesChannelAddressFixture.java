package com.tracebucket.x1.saleschannel.test.fixture;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;
import com.tracebucket.x.saleschannel.query.model.AddressEntry;
import com.tracebucket.x.saleschannel.query.model.SalesChannelEntry;
import com.tracebucket.x1.saleschannel.test.builder.SalesChannelAddressBuilder;
import com.tracebucket.x1.saleschannel.test.builder.SalesChannelBuilder;

public class SalesChannelAddressFixture {

    public static AddressEntry standardSalesChannelAddress(){
        AddressEntry salesChannelAddress= SalesChannelAddressBuilder.asSalesChannelAddress()
                .withCity("Bangalore")
                .build();
        return salesChannelAddress;
    }

    public static AddressEntry standardSalesChannelAddress2(){
        AddressEntry salesChannelAddress = SalesChannelAddressBuilder.asSalesChannelAddress()
                .withLine1("Line1")
                .withLine2("Line2")
                .withCity("City")
                .withState("State")
                .withCountry("Country")
                .withPincode("560009")
                .withWebsite("Test@test.com")
                .build();
        return salesChannelAddress;
    }
}
