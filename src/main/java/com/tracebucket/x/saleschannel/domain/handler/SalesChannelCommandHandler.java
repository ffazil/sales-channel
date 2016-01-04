package com.tracebucket.x.saleschannel.domain.handler;

import com.tracebucket.x.saleschannel.domain.command.*;
import com.tracebucket.x.saleschannel.domain.exception.SalesChannelException;
import com.tracebucket.x.saleschannel.domain.model.Address;
import com.tracebucket.x.saleschannel.domain.model.Contact;
import com.tracebucket.x.saleschannel.domain.model.SalesChannel;
import com.tracebucket.x.saleschannel.query.model.SalesChannelEntry;
import com.tracebucket.x.saleschannel.query.repository.SalesChannelEntryRepository;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Madhavi on 09-09-2015.
 */
@Component
public class SalesChannelCommandHandler {

    @Autowired
    private Repository<SalesChannel> salesChannelRepository;

    @Autowired
    private SalesChannelEntryRepository salesChannelEntryRepository;

    @CommandHandler
    public void createSalesChannel(CreateSalesChannelCommand command){


        SalesChannelEntry existingSalesChannel = salesChannelEntryRepository.findByName(command.getName());
        if(existingSalesChannel == null) {
            SalesChannel salesChannel = new SalesChannel(command.getId(), command.getName(), command.getCode(),
                    command.getDescription(), command.getChannelType(), command.getStartTime(), command.getEndTime());
            salesChannelRepository.add(salesChannel);
        }
        else
            throw new SalesChannelException("SalesChannel Exists. Cannot Create sales channel with the same name");

    }


    @CommandHandler
    public void deleteSalesChannel(DeleteSalesChannelCommand command){
        SalesChannel salesChannel = salesChannelRepository.load(command.getId());
        salesChannel.delete();
    }

    @CommandHandler
    public void updateSalesChannel(UpdateSalesChannelCommand command){
        SalesChannel salesChannel = salesChannelRepository.load(command.getId());
        if (salesChannel == null)
            throw new SalesChannelException("Sales Channel Not Found");
        else
            salesChannel.update(command.getId(), command.getName(), command.getCode(), command.getDescription(),command.getChannelType());

    }

    @CommandHandler
    public void addSalesChannelAddress(AddSalesChannelAddressCommand command){
        SalesChannel salesChannel = salesChannelRepository.load(command.getSalesChannelid());
        Address address = new Address();
        address.setLine1(command.getLine1());
        address.setLine2(command.getLine2());
        address.setCity(command.getCity());
        address.setState(command.getState());
        address.setCountry(command.getCountry());
        address.setPincode(command.getPincode());
        address.setWebsite(command.getWebsite());
        salesChannel.addAddress(address);

    }

    @CommandHandler
    public void addSalesChannelContact(AddSalesChannelContactCommand command){
        SalesChannel salesChannel = salesChannelRepository.load(command.getSalesChannelid());
        Contact contact = new Contact();
        contact.setName(command.getName());
        contact.setPhone(command.getPhone());
        contact.setEmail(command.getEmail());
        contact.setWorkTimeFrom(command.getWorkTimeFrom());
        contact.setWorkTimeTo(command.getWorkTimeTo());
        contact.setMobile(command.getMobile());
        contact.setFax(command.getFax());
        salesChannel.addContactPerson(contact);

    }


}
