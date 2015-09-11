package com.tracebucket.x.saleschannel.domain.model;

import com.tracebucket.x.saleschannel.domain.event.SalesChannelCreatedEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.repository.Repository;

import javax.validation.constraints.NotNull;

/**
 * Created by Madhavi on 08-09-2015.
 */
public class SalesChannel extends AbstractAnnotatedAggregateRoot<String> {

    private Repository<SalesChannel> salesChannelRepository;

  /*  *//**
     * The constant serialVersionUID
     *//*
    private static final long serialVersionUID = -5977984483620451665L;
*/

    @AggregateIdentifier
    private String id;


    public SalesChannel(String id, String name, String description, SalesChannelType channelType) {
        apply(new SalesChannelCreatedEvent(id, name, description, channelType));
    }

    public SalesChannel() {

    }

    /*
        void ownedByOrganization(EntityId organizationId);
        void ownedByMerchant(EntityId merchantId);
    */
    void addAddress(DefaultAddress address) {

    }

    void addContactPerson(DefaultPerson contactPerson) {

    }

    void addCatalogue() {

    }

}
