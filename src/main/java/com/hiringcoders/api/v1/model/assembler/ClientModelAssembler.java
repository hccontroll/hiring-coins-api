package com.hiringcoders.api.v1.model.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hiringcoders.api.v1.model.ClientModel;
import com.hiringcoders.domain.model.Client;

@Component
public class ClientModelAssembler {
	
	private ModelMapper modelMapper;
	
	@Autowired
	public ClientModelAssembler(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public ClientModel toModel(Client client) {
		return modelMapper.map(client, ClientModel.class);
	}

	public List<ClientModel> toCollectionModel(List<Client> clients) {
		return clients.stream()
				.map(client -> toModel(client))
				.collect(Collectors.toList());
	}
	
}