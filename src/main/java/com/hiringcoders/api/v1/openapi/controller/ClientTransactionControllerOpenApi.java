package com.hiringcoders.api.v1.openapi.controller;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;

import com.hiringcoders.api.exceptionhandler.Problem;
import com.hiringcoders.api.v1.model.TransactionSummary;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Clients Hiring Coins", name = "Clients")
public interface ClientTransactionControllerOpenApi {

	@Operation(description = "Search for a Client Transactions")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Paged list of a client's transactions"),
		@ApiResponse(responseCode = "404", description = "Client not found", 
				content = @Content(mediaType = "application/json", 
					schema = @Schema(implementation = Problem.class))) 
	})
	Page<TransactionSummary> list(
			@Parameter(name = "clientUuid", description = "Client uuid", required = true)
			String clientUuid, 
			
			@ParameterObject 
			Pageable pageable);

}
