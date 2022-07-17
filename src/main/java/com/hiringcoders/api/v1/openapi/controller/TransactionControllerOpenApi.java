package com.hiringcoders.api.v1.openapi.controller;

import org.springframework.web.bind.annotation.PathVariable;

import com.hiringcoders.api.exceptionhandler.Problem;
import com.hiringcoders.api.v1.input.TransactionInput;
import com.hiringcoders.api.v1.model.TransactionModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Transações Hiring Coins", name = "Transações")
public interface TransactionControllerOpenApi {

	@Operation(description = "Busca uma Transação pela UUID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Transação encontrada"),
		@ApiResponse(responseCode = "404", description = "Transação não encontrada", 
				content = @Content(mediaType = "application/json", 
					schema = @Schema(implementation = Problem.class))) 
	})
	TransactionModel find(String transactionUuid);

	@Operation(description = "Adiciona uma Transação")
	@ApiResponses({ 
		@ApiResponse(responseCode = "201", description = "Transação cadastrada"),
		@ApiResponse(responseCode = "400", description = "Cliente não encontrado", 
		content = @Content(mediaType = "application/json", 
			schema = @Schema(allOf = { com.hiringcoders.api.exceptionhandler.Problem.class }))) 
	})
	TransactionModel adicionar(
			@Parameter(name = "corpo", description = "Representação de uma nova Transação", required = true) 
			TransactionInput transactionInput);

}
