package com.hiringcoders.api.v1.openapi.controller;

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

@Tag(description = "Transactions Hiring Coins", name = "Transactions")
public interface TransactionControllerOpenApi {

	@Operation(description = "Search for a Transaction by UUID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Transaction found"),
		@ApiResponse(responseCode = "404", description = "Transaction not found", 
				content = @Content(mediaType = "application/json", 
					schema = @Schema(implementation = Problem.class))) 
	})
	TransactionModel find(String transactionUuid);

	@Operation(description = "Add a new transaction")
	@ApiResponses({ 
		@ApiResponse(responseCode = "201", description = "Registered Transaction"),
		@ApiResponse(responseCode = "400", description = "Client not found", 
		content = @Content(mediaType = "application/json", 
			schema = @Schema(allOf = { com.hiringcoders.api.exceptionhandler.Problem.class }))) 
	})
	TransactionModel adicionar(
			@Parameter(name = "body", description = "Representation of a new Transaction", required = true) 
			TransactionInput transactionInput);

}
