package com.hiringcoders.api.v1.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientInput {

	@NotBlank
	@Size(max = 100)
	private String name;

	@NotBlank
	@Email
	@Size(max = 100)
	private String email;
	
}