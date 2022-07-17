package com.hiringcoders.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiringcoders.api.v1.model.TransactionSummary;
import com.hiringcoders.api.v1.model.assembler.TransactionSummaryAssembler;
import com.hiringcoders.api.v1.openapi.controller.ClientTransactionControllerOpenApi;
import com.hiringcoders.domain.model.Client;
import com.hiringcoders.domain.model.Transaction;
import com.hiringcoders.domain.repository.TransactionRepository;
import com.hiringcoders.domain.service.ClientRegistrationService;

@RestController
@RequestMapping(path = "/v1/clients/{clientUuid}/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientTransactionController implements ClientTransactionControllerOpenApi {
	
	@Autowired
	private ClientRegistrationService clientRegistration;

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionSummaryAssembler transactionSummaryAssembler;

	@GetMapping
	public Page<TransactionSummary> list(@PathVariable String clientUuid, @PageableDefault(size = 10) Pageable pageable) {
		Client client = clientRegistration.findClientByUuid(clientUuid);
		
		Page<Transaction> transactionsPage = transactionRepository.findByClientId(client.getId(), pageable);

		List<TransactionSummary> transactionsSummaryList = transactionSummaryAssembler
				.toCollectionModel(transactionsPage.getContent());

		Page<TransactionSummary> transactionsSummaryPage = new PageImpl<>(transactionsSummaryList, pageable,
				transactionsPage.getTotalElements());

		return transactionsSummaryPage;
	}

}
