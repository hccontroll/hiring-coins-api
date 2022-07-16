package com.hiringcoders.api.v1.input.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hiringcoders.api.v1.input.TransactionInput;
import com.hiringcoders.domain.model.Transaction;

@Component
public class TransactionInputDisassembler {
	
    @Autowired
    private ModelMapper modelMapper;
    
	public Transaction toDomainObject(TransactionInput transactionInput) {
        return modelMapper.map(transactionInput, Transaction.class);
    }
    
    public void copyToDomainObject(TransactionInput transactionInput, Transaction transaction) {
        modelMapper.map(transactionInput, transaction);
    }

}
