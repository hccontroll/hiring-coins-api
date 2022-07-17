package com.hiringcoders.api.v1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hiringcoders.api.v1.input.TransactionInput;
import com.hiringcoders.api.v1.input.disassembler.TransactionInputDisassembler;
import com.hiringcoders.api.v1.model.TransactionModel;
import com.hiringcoders.api.v1.model.assembler.TransactionModelAssembler;
import com.hiringcoders.api.v1.openapi.controller.TransactionControllerOpenApi;
import com.hiringcoders.domain.exception.ClientNotFoundException;
import com.hiringcoders.domain.exception.DomainException;
import com.hiringcoders.domain.model.Transaction;
import com.hiringcoders.domain.service.TransactionRegistrationService;

@RestController
@RequestMapping(path = "/v1/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController implements TransactionControllerOpenApi {

	@Autowired
	private TransactionModelAssembler transactionModelAssembler;
	
	@Autowired
	private TransactionRegistrationService transactionRegistration;
	
	@Autowired
	private TransactionInputDisassembler transactionInputDisassembler;
	
	@Override
	@GetMapping(path = "/{transactionUuid}")
	public TransactionModel find(@PathVariable String transactionUuid) {
		Transaction transaction = transactionRegistration.findTransactionByUuid(transactionUuid);

		return transactionModelAssembler.toModel(transaction);
	}
	
	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TransactionModel adicionar(@RequestBody @Valid TransactionInput transactionInput) {		
		try {
			Transaction transaction = transactionInputDisassembler.toDomainObject(transactionInput);
			transaction = transactionRegistration.save(transaction);

			return transactionModelAssembler.toModel(transaction);
		} catch (ClientNotFoundException e) {
			throw new DomainException(e.getMessage());
		}	
	}


}
