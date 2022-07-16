package com.hiringcoders.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiringcoders.domain.exception.TransactionNotFoundException;
import com.hiringcoders.domain.model.Client;
import com.hiringcoders.domain.model.Transaction;
import com.hiringcoders.domain.repository.TransactionRepository;

@Service
public class TransactionRegistrationService {

	private TransactionRepository transactionRepository;

	private ClientRegistrationService clientRegistration;

	@Autowired
	public TransactionRegistrationService(TransactionRepository transactionRepository,
			ClientRegistrationService clientRegistration) {
		this.transactionRepository = transactionRepository;
		this.clientRegistration = clientRegistration;
	}

	public Transaction findTransactionByUuid(String transactionUuid) {
		return transactionRepository.findByUuid(transactionUuid)
				.orElseThrow(() -> new TransactionNotFoundException(transactionUuid));
	}

	@Transactional
	public Transaction save(Transaction transaction) {
		Client client = clientRegistration.findClientByUuid(transaction.getClient().getUuid());		
		
		client.registerTransaction(transaction);
		
		clientRegistration.save(client);		
		return transactionRepository.save(transaction);
	}

}
