package com.tracebucket.x1.saleschannel.test.fixture;

import com.tracebucket.x.saleschannel.domain.model.SalesChannel;
import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;
import com.tracebucket.x.saleschannel.query.model.SalesChannelEntry;
import com.tracebucket.x1.saleschannel.test.builder.SalesChannelBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sadath on 25-Nov-14.
 */
public class SalesChannelFixture {

    public static SalesChannelEntry standardSalesChannel(){
/*
        Map<String, EmailType> emails = new HashMap<String, EmailType>();
        emails.put("sadath@mmp.com", EmailType.PERSONAL);
        Map<String, PhoneType> phones = new HashMap<String, PhoneType>();
        phones.put("9898988889888", PhoneType.MOBILE);
*/
        SalesChannelEntry salesChannel= SalesChannelBuilder.asSalesChannel()
                .withName("CATALOGUE1")
                .build();
        return salesChannel;
    }

    public static SalesChannelEntry standardSalesChannel2(){
        SalesChannelEntry salesChannel = SalesChannelBuilder.asSalesChannel()
                .withName("CATALOGUE2")
                .withDescription("TEST CAT 2")
                .withChannelType(SalesChannelType.CATALOGUE)
                .build();
        return salesChannel;
    }
}
