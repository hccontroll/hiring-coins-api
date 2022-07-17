package com.hiringcoders.api.v1.openapi.controller;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hiringcoders.api.exceptionhandler.Problem;
import com.hiringcoders.api.v1.input.ClientInput;
import com.hiringcoders.api.v1.model.ClientModel;
import com.hiringcoders.domain.filter.ClientFilter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Clients Hiring Coins", name = "Clients")
public interface ClientControllerOpenApi {
	
	@Operation(description = "Search Clients")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Paginated list of clients")
	})
	Page<ClientModel> list(
			@ParameterObject
			ClientFilter filter, 			
			
			@ParameterObject 
			Pageable pageable);
	
	@Operation(description = "Search for a Client by UUID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Client found"),
		@ApiResponse(responseCode = "404", description = "Client not found", 
				content = @Content(mediaType = "application/json", 
					schema = @Schema(implementation = Problem.class))) 
	})
	ClientModel find(String clientUuid);
	
	@Operation(description = "Saves a new client or updates a existent client")
	@ApiResponses({ 
		@ApiResponse(responseCode = "200", description = "Client created or updated")
	})
	ClientModel saveOrUpdate(
			@Parameter(name = "body", description = "Client data", required = true) 
			ClientInput clientInput);

}
