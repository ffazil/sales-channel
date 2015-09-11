package com.tracebucket.x.saleschannel.domain.handler;

import com.tracebucket.x.saleschannel.domain.command.CreateSalesChannelCommand;
import com.tracebucket.x.saleschannel.domain.model.SalesChannel;
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

    @CommandHandler
    public void createTask(CreateSalesChannelCommand command){
        SalesChannel salesChannel = new SalesChannel(command.getId(), command.getName(),
                                                     command.getDescription(), command.getChannelType());
        salesChannelRepository.add(salesChannel);
    }
}
