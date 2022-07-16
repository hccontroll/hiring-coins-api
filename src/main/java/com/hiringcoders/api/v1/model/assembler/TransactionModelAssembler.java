package com.hiringcoders.api.v1.model.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hiringcoders.api.v1.model.TransactionModel;
import com.hiringcoders.domain.model.Transaction;

@Component
public class TransactionModelAssembler {
	
	private ModelMapper modelMapper;
	
	@Autowired
	public TransactionModelAssembler(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public TransactionModel toModel(Transaction transaction) {
		return modelMapper.map(transaction, TransactionModel.class);
	}

	public List<TransactionModel> toCollectionModel(List<Transaction> transactions) {
		return transactions.stream()
				.map(transaction -> toModel(transaction))
				.collect(Collectors.toList());
	}

}
