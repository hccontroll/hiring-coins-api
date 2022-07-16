package com.hiringcoders.domain.exception;

public class TransactionNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public TransactionNotFoundException(String transactionUuid) {
		super(String.format("Não existe uma Transação com UUID %s", transactionUuid));
	}

}