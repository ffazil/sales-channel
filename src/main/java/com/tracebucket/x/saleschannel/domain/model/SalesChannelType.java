package com.tracebucket.x.saleschannel.domain.model;

/**
 * Created by Madhavi on 08-09-2015.
 */
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SalesChannelType {
    WEB ,
    BRICK_MORTOR,
    CALL_CENTER,
    CATALOGUE,
    MOBILE,
    VENDING,
    SUPPORT_STAFF;
}
