package com.hiringcoders.api.v1.model.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hiringcoders.api.v1.model.TransactionSummary;
import com.hiringcoders.domain.model.Transaction;

@Component
public class TransactionSummaryAssembler {

	private ModelMapper modelMapper;
	
	@Autowired
	public TransactionSummaryAssembler(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public TransactionSummary toModel(Transaction transaction) {
		return modelMapper.map(transaction, TransactionSummary.class);
	}

	public List<TransactionSummary> toCollectionModel(List<Transaction> transactions) {
		return transactions.stream()
				.map(transaction -> toModel(transaction))
				.collect(Collectors.toList());
	}

}