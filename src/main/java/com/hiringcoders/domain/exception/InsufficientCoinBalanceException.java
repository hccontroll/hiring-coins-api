package com.hiringcoders.domain.exception;

public class InsufficientCoinBalanceException extends DomainException {

	private static final long serialVersionUID = 1L;

	public InsufficientCoinBalanceException() {
		super("Saldo Insuficiente");
	}
	
}
