package com.hiringcoders.domain.exception;

public class ClientNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public ClientNotFoundException(String clientUuid) {
		super(String.format("Não existe um Cliente com UUID %d", clientUuid));
	}

}