package com.tracebucket.x.saleschannel.domain.model;

import com.tracebucket.x.saleschannel.domain.event.*;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.repository.Repository;

import java.util.*;

/**
 * Created by Madhavi on 08-09-2015.
 */

public class SalesChannel extends AbstractAnnotatedAggregateRoot<String> {

    private Repository<SalesChannel> salesChannelRepository;

    @AggregateIdentifier
    private String id;

    private Set<Address> address;

    private  Set<Contact> contact;


    public SalesChannel(String id, String name, String code, String description,
                        SalesChannelType channelType, Date startTime, Date endTime) {
        apply(new SalesChannelCreatedEvent(id, name, code, description, channelType, startTime, endTime));
    }

    public SalesChannel() {

    }

    public void delete() {
        apply(new SalesChannelDeletedEvent(this.id));
    }

    public void update(String id, String name,String description,String code, SalesChannelType channelType) {
        apply(new SalesChannelUpdatedEvent(id, name, code, description, channelType));
    }
    /*
        void ownedByOrganization(EntityId organizationId);
        void ownedByMerchant(EntityId merchantId);
    */
    public void addAddress(Address address) {

        if(this.address == null)
            this.address = new HashSet<Address>();
        this.address.add(address);
        apply(new SalesChannelAddressAddedEvent(id, address));
    }

   public void addContactPerson(Contact contactPerson) {
       if(this.contact == null)
       this.contact = new HashSet<Contact>();
       this.contact.add(contactPerson);
       apply(new SalesChannelContactAddedEvent(id, contactPerson));
    }

    @EventHandler
    void on(SalesChannelCreatedEvent event) {
        this.id = event.getId();
    }


    void addCatalogue() {
    }

}
