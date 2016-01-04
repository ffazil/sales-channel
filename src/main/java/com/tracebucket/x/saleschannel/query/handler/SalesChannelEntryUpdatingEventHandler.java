package com.tracebucket.x.saleschannel.query.handler;

import java.util.HashSet;

import com.tracebucket.x.saleschannel.domain.event.*;
import com.tracebucket.x.saleschannel.query.model.ContactEntry;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracebucket.x.saleschannel.query.model.AddressEntry;
import com.tracebucket.x.saleschannel.query.model.SalesChannelEntry;
import com.tracebucket.x.saleschannel.query.repository.SalesChannelEntryRepository;

@Component
public class SalesChannelEntryUpdatingEventHandler {

	private final SalesChannelEntryRepository salesChannelEntryRepository;
	
	@Autowired
	public SalesChannelEntryUpdatingEventHandler(SalesChannelEntryRepository salesChannelEntryRepository) {
		this.salesChannelEntryRepository = salesChannelEntryRepository;
	}
	
	@EventHandler
	void on(SalesChannelCreatedEvent event) {
		SalesChannelEntry salesChannel = new SalesChannelEntry(event.getId(), event.getName(), event.getCode(), event.getDescription(),
												event.getChannelType(), event.getStartTime(), event.getEndTime());
		salesChannelEntryRepository.save(salesChannel);
	}

	@EventHandler
	void on (SalesChannelDeletedEvent event) {
		SalesChannelEntry salesChannelEntry = salesChannelEntryRepository.findOne(event.getId());

		salesChannelEntryRepository.delete(salesChannelEntry.getId());
	}

	@EventHandler
	void on (SalesChannelUpdatedEvent event) {
		SalesChannelEntry salesChannelEntry = salesChannelEntryRepository.findOne(event.getId());
		salesChannelEntry.setDescription(event.getDescription());
		salesChannelEntry.setChannelType(event.getChannelType());
		salesChannelEntryRepository.save(salesChannelEntry);
	}


	@EventHandler
	void on (SalesChannelAddressAddedEvent event) {
		SalesChannelEntry salesChannelEntry = salesChannelEntryRepository.findOne(event.getSalesChannelId());
		AddressEntry addressEntry = new AddressEntry(event.getLine1(), event.getLine2(), event.getCity(), event.getState(), event.getCountry(),
				event.getPincode(), event.getWebsite());

		if(salesChannelEntry.getAddressEntry() == null) salesChannelEntry.setAddressEntry(new HashSet<AddressEntry>());
		salesChannelEntry.getAddressEntry().add(addressEntry);
		salesChannelEntryRepository.save(salesChannelEntry);
	}

	@EventHandler
	void on (SalesChannelContactAddedEvent event) {
		SalesChannelEntry salesChannelEntry = salesChannelEntryRepository.findOne(event.getSalesChannelId());
		ContactEntry contactEntry = new ContactEntry(event.getName(), event.getPhone(), event.getEmail(), event.getFax(), event.getMobile(),
				event.getWorkTimeFrom(), event.getWorkTimeTo());

		if(salesChannelEntry.getContactEntry() == null) salesChannelEntry.setContactEntry(new HashSet<ContactEntry>());
		salesChannelEntry.getContactEntry().add(contactEntry);
		salesChannelEntryRepository.save(salesChannelEntry);
	}


}
