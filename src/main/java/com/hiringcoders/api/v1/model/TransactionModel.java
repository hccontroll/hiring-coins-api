package com.hiringcoders.api.v1.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.hiringcoders.domain.model.TransactionType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionModel {
	
	@Schema(example = "1711f651-b98c-43cc-936c-a1968e6de8cd")
	private String uuid;
	
	@Schema(example = "533988cb-8cda-49b5-8607-c53b649701e9")
	private String clientUuid;
	
	@Schema(example = "Douglas Rodrigues")
	private String clientName;
	
	@Schema(example = "wandersondouglasr@gmail.com")
	private String clientEmail;
	
	@Schema(example = "c53b649701e9")
	private String purchaseId;
	
	@Schema(example = "50.6")
	private BigDecimal purchaseValue;
	
	@Schema(example = "2022-07-16T13:51:05Z")
	private OffsetDateTime purchaseDate;
	
	@Schema(example = "CREDIT")
	private TransactionType type;
	
	@Schema(example = "50")
	private Long coins;

}