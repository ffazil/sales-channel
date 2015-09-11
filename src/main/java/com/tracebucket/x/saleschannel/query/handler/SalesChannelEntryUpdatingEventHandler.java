package com.tracebucket.x.saleschannel.query.handler;

import com.tracebucket.x.saleschannel.domain.event.SalesChannelCreatedEvent;
import com.tracebucket.x.saleschannel.query.model.SalesChannelEntry;
import com.tracebucket.x.saleschannel.query.repository.SalesChannelEntryRepository;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesChannelEntryUpdatingEventHandler {

	private final SalesChannelEntryRepository salesChannelEntryRepository;
	
	@Autowired
	public SalesChannelEntryUpdatingEventHandler(SalesChannelEntryRepository salesChannelEntryRepository) {
		this.salesChannelEntryRepository = salesChannelEntryRepository;
	}
	
	@EventHandler
	void on(SalesChannelCreatedEvent event) {
		SalesChannelEntry salesChannel = new SalesChannelEntry(event.getId(), event.getName(), event.getDescription(),event.getChannelType());
		salesChannelEntryRepository.save(salesChannel);
	}

/*
	@EventHandler
	void on(TaskCompletedEvent event) {
        TaskEntry task = taskEntryRepository.findOne(event.getId());
		task.setCompleted(true);
		
		taskEntryRepository.save(task);


	}
	
	@EventHandler
	void on(TaskTitleModifiedEvent event) {
		TaskEntry task = taskEntryRepository.findOne(event.getId());
		task.setTitle(event.getTitle());
		
		taskEntryRepository.save(task);
	}
	
	@EventHandler
	void on (TaskStarredEvent event) {
		TaskEntry task = taskEntryRepository.findOne(event.getId());
		task.setStarred(true);
		
		taskEntryRepository.save(task);
	}
	
	@EventHandler
	void on (TaskUnstarredEvent event) {
		TaskEntry task = taskEntryRepository.findOne(event.getId());
		task.setStarred(false);
		
		taskEntryRepository.save(task);
	}
*/
}
