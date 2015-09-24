package com.tracebucket.x.saleschannel.rest.controller;

import com.tracebucket.x.saleschannel.domain.command.AddSalesChannelAddressCommand;
import com.tracebucket.x.saleschannel.domain.command.CreateSalesChannelCommand;
import com.tracebucket.x.saleschannel.domain.command.DeleteSalesChannelCommand;
import com.tracebucket.x.saleschannel.domain.command.UpdateSalesChannelCommand;
import com.tracebucket.x.saleschannel.query.model.SalesChannelEntry;
import com.tracebucket.x.saleschannel.query.repository.SalesChannelEntryRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.domain.DefaultIdentifierFactory;
import org.axonframework.domain.IdentifierFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class SalesChannelController {

	private final IdentifierFactory identifierFactory = new DefaultIdentifierFactory();
	
	@Autowired
	private SalesChannelEntryRepository salesChannelEntryRepository;

	@Autowired
	private CommandGateway commandGateway;


	/*@RequestMapping(value = "/saleschannel/name", method = RequestMethod.GET)
	public ResponseEntity<SalesChannelEntry>
	SalesChannelEntry findByName(String name) {
		return  salesChannelEntryRepository.findByName(name);
	}*/

	@RequestMapping(value = "/saleschannel/{name}", method = RequestMethod.GET)
	public @ResponseBody SalesChannelEntry findByName(@PathVariable("name") String name) {
		return salesChannelEntryRepository.findByName(name);
	}




	@RequestMapping(value = "/saleschannels", method = RequestMethod.GET)
	public @ResponseBody
	Page<SalesChannelEntry> findAll( Pageable pageable) {
		return salesChannelEntryRepository.findAll(pageable);
	}


	@RequestMapping(value = "/saleschannel", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void createSalesChannel(@RequestBody @Valid com.tracebucket.x.saleschannel.rest.resource.CreateSalesChannelRequest request) {


		commandGateway.send(new CreateSalesChannelCommand(identifierFactory.generateIdentifier(),
				                                          request.getName(),
														  request.getCode(),
														  request.getDescription(),
													      request.getChannelType(),
				                                          request.getStartTime(),
														  request.getEndTime()));
	}


	@RequestMapping(value = "/saleschannel/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteSalesChannel(HttpServletRequest request, @PathVariable("id") String salesChannelId) {
		commandGateway.send(new DeleteSalesChannelCommand(salesChannelId));
	}

	@RequestMapping(value = "/saleschannel/update", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void updateSalesChannel(@RequestBody @Valid com.tracebucket.x.saleschannel.rest.resource.CreateSalesChannelRequest request) {


		commandGateway.send(new UpdateSalesChannelCommand(request.getId(),
				request.getName(),
				request.getCode(),
				request.getDescription(),
				request.getChannelType(),
				request.getStartTime(),
				request.getEndTime()));
	}

	@RequestMapping(value = "/saleschannel/address", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addSalesChannelAddress(@RequestBody @Valid com.tracebucket.x.saleschannel.rest.resource.SalesChannelAddressRequest request) {
		commandGateway.send(new AddSalesChannelAddressCommand(request.getSalesChannelId(), request.getLine1(), request.getLine2(),
				request.getCity(), request.getState(), request.getCountry(), request.getPincode(), request.getWebsite()));
	}


	/*@ExceptionHandler
	public void handleException(Principal principal, Throwable exception) {
		messagingTemplate.convertAndSendToUser(principal.getName(), "/queue/errors", exception.getMessage());
	}*/

}