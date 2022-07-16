package com.hiringcoders.api.v1.input.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hiringcoders.api.v1.input.ClientInput;
import com.hiringcoders.domain.model.Client;

@Component
public class ClientInputDisassembler {
	
    @Autowired
    private ModelMapper modelMapper;
    
    public Client toDomainObject(ClientInput clientInput) {
        return modelMapper.map(clientInput, Client.class);
    }
    
    public void copyToDomainObject(ClientInput clientInput, Client client) {
        modelMapper.map(clientInput, client);
    }

}
