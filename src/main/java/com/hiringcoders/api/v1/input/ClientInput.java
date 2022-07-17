package com.hiringcoders.api.v1.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Client")
@Getter
@Setter
public class ClientInput {

	@Schema(example = "Douglas Rodrigues", description = "Nome do Cliente", required = true)
	@NotBlank
	@Size(max = 100)
	private String name;

	@Schema(example = "wandersondouglasr@gmail.com", description = "E-mail do Cliente", required = true)
	@NotBlank
	@Email
	@Size(max = 100)
	private String email;
	
}