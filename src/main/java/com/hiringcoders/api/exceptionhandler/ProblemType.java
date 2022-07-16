package com.hiringcoders.api.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProblemType {

	INCOMPREHENSIBLE_MESSAGE("Mensagem incompreensível"),
	RESOURCE_NOT_FOUND("Recurso não encontrado"),
	DOMAIN_ERROR("Violação de regra de negócio"),
	INVALID_PARAMETERS("Parâmetros inválidos"),
	INVALID_DATA("Dados inválidos"),
	SYSTEM_ERROR("Erro de sistema");

	private String title;

}