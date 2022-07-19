package com.hiringcoders.api.v1.model;

import java.time.OffsetDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientModel {
	
	@Schema(example = "533988cb-8cda-49b5-8607-c53b649701e9")
	private String uuid;
	
	@Schema(example = "Douglas Rodrigues")
	private String name;
	
	@Schema(example = "wandersondouglasr@gmail.com")
	private String email;

	@Schema(example = "2022-07-16T13:51:05Z")
	private OffsetDateTime lastPurchase;
	
	@Schema(example = "50")
	private Long coinBalance;
	
}