package com.hiringcoders.api.v1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiringcoders.api.v1.input.ClientInput;
import com.hiringcoders.api.v1.input.disassembler.ClientInputDisassembler;
import com.hiringcoders.api.v1.model.ClientModel;
import com.hiringcoders.api.v1.model.assembler.ClientModelAssembler;
import com.hiringcoders.api.v1.openapi.controller.ClientControllerOpenApi;
import com.hiringcoders.domain.filter.ClientFilter;
import com.hiringcoders.domain.model.Client;
import com.hiringcoders.domain.repository.ClientRepository;
import com.hiringcoders.domain.service.ClientRegistrationService;

@RestController
@RequestMapping(path = "/v1/clients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController implements ClientControllerOpenApi {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientModelAssembler clientModelAssembler;
	
	@Autowired
	private ClientRegistrationService clientRegistration;
	
	@Autowired
	private ClientInputDisassembler clientInputDisassembler;

	@Override
	@GetMapping
	public Page<ClientModel> list(ClientFilter filter, @PageableDefault(size = 10) Pageable pageable) {
		Page<Client> clientsPage = clientRepository.findUsingFilter(filter, pageable);

		List<ClientModel> clientsModelList = clientModelAssembler.toCollectionModel(clientsPage.getContent());

		Page<ClientModel> clientsModelPage = new PageImpl<>(clientsModelList, pageable,
				clientsPage.getTotalElements());

		return clientsModelPage;
	}
	
	@Override
	@GetMapping(path = "/{clientUuid}")
	public ClientModel find(@PathVariable String clientUuid) {
		Client client = clientRegistration.findClientByUuid(clientUuid);

		return clientModelAssembler.toModel(client);
	}
	
	@Override
	@PutMapping
	public ClientModel saveOrUpdate(@RequestBody @Valid ClientInput clientInput) {
		Optional<Client> clientOptional = clientRepository.findByEmail(clientInput.getEmail());
		
		Client client;
		
		if (clientOptional.isPresent()) {
			client = clientOptional.get();
			clientInputDisassembler.copyToDomainObject(clientInput, client);
		} else {
			client = clientInputDisassembler.toDomainObject(clientInput);
		}
		
		client = clientRegistration.save(client);
		
		return clientModelAssembler.toModel(client);
	}

}
