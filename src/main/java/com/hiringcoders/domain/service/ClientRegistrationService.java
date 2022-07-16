package com.hiringcoders.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiringcoders.domain.exception.ClientNotFoundException;
import com.hiringcoders.domain.model.Client;
import com.hiringcoders.domain.repository.ClientRepository;

@Service
public class ClientRegistrationService {
	
	private ClientRepository clientRepository;
	
	@Autowired
	public ClientRegistrationService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public Client findClientByUuid(String clientUuid) {
		return clientRepository.findByUuid(clientUuid)
				.orElseThrow(() -> new ClientNotFoundException(clientUuid));
	}

	@Transactional
	public Client save(Client client) {
		return clientRepository.saveAndFlush(client);
	}

}
